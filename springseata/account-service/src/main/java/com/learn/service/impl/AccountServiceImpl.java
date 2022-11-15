package com.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Account;
import com.learn.entity.Log;
import com.learn.mapper.AccountMapper;
import com.learn.service.AccountService;
import com.learn.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    LogService logService;
    @Resource
    AccountMapper accountMapper;

    @Transactional
    @Override
    public void debit(String userId, Integer money, String orderId) {
        Account account = accountMapper.selectOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId)); // 根据用户id 查询用户 select * find account where user_id = userid
        account.setMoney(account.getMoney() - money); // 用户借了多少钱出去 所以账户减少借出去的钱
        accountMapper.updateById(account); // 更新
        int i = 1 / 0;
        // 保存日志
        Log log = new Log();
        log.setGmtCreate(new Date());
        log.setGmtModified(new Date());
        log.setMoney(money);
        log.setOrderId(orderId);
        logService.save(log);

    }
}
