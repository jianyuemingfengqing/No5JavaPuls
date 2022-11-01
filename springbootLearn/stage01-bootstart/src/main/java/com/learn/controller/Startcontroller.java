package com.learn.controller;

//import com.learn.properties.DataSourceProperties;
//import com.learn.properties.DataSourceProperties2;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
//@EnableConfigurationProperties(DataSourceProperties2.class)
public class Startcontroller {
    @Resource
    DataSource dataSource;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(dataSource.getClass());
        return "hello  Spring World";
    }
//    @Resource
//    DataSourceProperties dataSourceProperties;
//    DataSourceProperties2 dataSourceProperties2;

//    @RequestMapping("/hello2")
//    public String dataTest() {
////        return dataSourceProperties.toString();
////        return dataSourceProperties2.toString();
//        return "";
//    }
}
