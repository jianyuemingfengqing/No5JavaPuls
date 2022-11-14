package com.learn;

import com.learn.entity.Account;
import com.learn.mapper.AccountMapper;
import com.learn.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class AccountTest {
    @Resource
    AccountService accountService;
    @Resource
    AccountMapper accountMapper;

    @Test // 使用junit5
    public void testSelect(){
        List<Account> accounts = accountMapper.selectList(null);
        accounts.forEach(System.out::println);


    }
}
