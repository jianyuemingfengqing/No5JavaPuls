package com.learn.controller;

import com.learn.properties.DataSourceProperties;
import com.learn.properties.DataSourceProperties2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableConfigurationProperties(DataSourceProperties2.class)
public class Startcontroller {
    @RequestMapping("/hello")
    public String hello() {
        return "hello  Spring World";
    }
    @Resource
//    DataSourceProperties dataSourceProperties;
    DataSourceProperties2 dataSourceProperties2;

    @RequestMapping("/hello2")
    public String dataTest() {
        return dataSourceProperties2.toString();
    }
}
