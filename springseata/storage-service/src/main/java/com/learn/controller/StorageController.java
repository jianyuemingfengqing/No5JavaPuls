package com.learn.controller;

import com.learn.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Resource
    StorageService storageService;

    @RequestMapping("/deduct")//扣除
    public String deduct(String commodityCode,Integer count){
storageService.deduct(commodityCode,count);
            return "success";
        }
}
