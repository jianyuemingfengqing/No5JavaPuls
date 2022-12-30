package com.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "order_tbl")
public class Order {
    @TableId(type = IdType.AUTO)
    private String id;
    private String userId;
    private String commodityCode;
    private Integer money;
    private Integer count;
}