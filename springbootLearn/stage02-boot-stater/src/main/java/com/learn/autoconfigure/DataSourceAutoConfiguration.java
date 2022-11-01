package com.learn.autoconfigure;


import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@SpringBootConfiguration
public class DataSourceAutoConfiguration {
    @Resource
    DataSourceProperties dataSourceProperties;

    @Bean
    @ConditionalOnProperty(value = "spring.datasource.jdbc.type",havingValue ="druid" )
    public DataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return druidDataSource;
    }

    @Bean
    @ConditionalOnProperty(value = "spring.datasource.jdbc.type",havingValue ="c3p0" )
    public DataSource c3p0DataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setUser(dataSourceProperties.getUsername());
        comboPooledDataSource.setPassword(dataSourceProperties.getPassword());
        comboPooledDataSource.setJdbcUrl(dataSourceProperties.getUrl());
        comboPooledDataSource.setDriverClass(dataSourceProperties.getDriverClassName());
        return comboPooledDataSource;
    }


}
