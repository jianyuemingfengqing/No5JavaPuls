package com.learn.springelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor //全参构造方法
@NoArgsConstructor //无参构造方法
@Data //getter setter 方法
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
}
