package com.learn.controller;

import com.learn.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("/create")
    public String create(String userId,String commodityCode, Integer count){
        orderService.create(userId,commodityCode,count);
            return "success";
        }
}
