package com.learn.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "log_tbl")
public class Log {
    @TableId
    private String id;
    private Date gmtCreate;
    private Date gmtModified;
    private String orderId;
    private Integer money;
}