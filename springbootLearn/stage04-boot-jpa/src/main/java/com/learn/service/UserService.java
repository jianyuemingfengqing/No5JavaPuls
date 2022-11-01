package com.learn.service;

import com.learn.domain.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();

    User findUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

}
