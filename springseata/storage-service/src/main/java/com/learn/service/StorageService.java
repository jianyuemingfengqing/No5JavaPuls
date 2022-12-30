package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Storage;

public interface StorageService extends IService<Storage> {
    void deduct(String commodityCode, Integer count);//存储
}
