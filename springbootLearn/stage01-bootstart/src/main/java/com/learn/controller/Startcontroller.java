package com.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Startcontroller {
    @RequestMapping("/hello")
    public String hello(){

            return "hello  Spring World";
        }
}
