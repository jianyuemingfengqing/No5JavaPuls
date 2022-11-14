package com.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Order;
import com.learn.feign.AccountClient;
import com.learn.mapper.OrderMapper;
import com.learn.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>  implements OrderService {
    @Resource
    AccountClient accountClient;

    @Override
    public void create(String userId, String commodityCode, Integer count) {
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(5);
        this.save(order);
        accountClient.debit(userId,5,order.getId());
    }
}
