package com.learn.controller;

import com.learn.domain.User;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findUsers();
    }
    @RequestMapping("/save")
    public String save(@RequestBody User user){
        userService.saveUser(user);
            return "save success";
        }
}
