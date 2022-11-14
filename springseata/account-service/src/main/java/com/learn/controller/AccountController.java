package com.learn.controller;

import com.learn.service.AccountService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AccountController {
    @Resource
    AccountService accountService;




}
