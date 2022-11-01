package com.learn.controller;

import com.learn.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Startcontroller {
    @RequestMapping("/hello")
    public String hello() {
        return "hello  Spring World";
    }

    @Resource
    DataSourceProperties dataSourceProperties;
    @RequestMapping("/hello2")
    public String dataTest(){
    
            return dataSourceProperties.toString();
        }
}
