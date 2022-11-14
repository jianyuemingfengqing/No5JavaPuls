package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Order;

public interface OrderService extends IService<Order> {
    void create(String userId, String commodityCode, Integer count);
}
