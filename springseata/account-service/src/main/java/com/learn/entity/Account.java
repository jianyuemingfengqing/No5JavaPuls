package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("account_tbl")
@Data
public class Account {
    private Integer id;
    private String userId;
    private Integer money;


}
