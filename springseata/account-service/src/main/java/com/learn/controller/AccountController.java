package com.learn.controller;

import com.learn.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping("/debit") //借款
    public String debit(String userId, Integer money, String orderId) {
        accountService.debit(userId, money, orderId);
        return "success";
    }


}
