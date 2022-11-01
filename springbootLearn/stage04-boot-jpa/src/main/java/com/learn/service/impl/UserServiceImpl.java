package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.domain.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public List<User> findUsers() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
