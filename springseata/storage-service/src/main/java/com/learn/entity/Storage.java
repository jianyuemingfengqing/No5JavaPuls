package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "storage_tbl")
public class Storage {

    @TableId
    private Long id;
    private String commodityCode;
    private Integer count;
}