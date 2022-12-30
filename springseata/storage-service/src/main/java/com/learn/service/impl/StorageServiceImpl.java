package com.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.entity.Storage;
import com.learn.mapper.StorageMapper;
import com.learn.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    StorageMapper storageMapper;
    @Transactional
    @Override
    public void deduct(String commodityCode, Integer count) {

        Storage storage = storageMapper.selectOne(new LambdaQueryWrapper<Storage>().eq(Storage::getCommodityCode, commodityCode));
        storage.setCount(storage.getCount() - count);
        storageMapper.updateById(storage);

    }
}
