package com.learn.service.impl;

import com.learn.dao.UserMapper;
import com.learn.pojo.User;
import com.learn.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    RedisTemplate<String, List<User>> redisTemplate;

    @Override
    @Transactional(readOnly = true ,propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        //从缓存中查询数据  规定存储用户信息使用string类型进行存储, 存储的key就是userList
        List<User> userList = redisTemplate.boundValueOps("userList").get();
        //如果缓存中没有数据, 查询数据库 , 将查询到的数据放入缓存
        if(userList==null){
            userList = userMapper.selectAll();
            redisTemplate.boundValueOps("userList").set(userList);
            System.out.println("从数据库中查询...");
        }else {
            System.out.println("从缓存中查询.....");
        }

        //如果缓存中有数据, 直接返回
        return userList ;
    }

}
