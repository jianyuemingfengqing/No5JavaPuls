package com.learn.dao;

import com.learn.pojo.User;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper  //自动创建代理对象
public interface UserMapper extends Mapper<User> {
}
