CREATE DATABASE guli_order;
USE guli_order;
CREATE TABLE `t_order`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
    `product_id`     VARCHAR(255) DEFAULT NULL COMMENT '商品id',
    `user_id`        VARCHAR(255) DEFAULT NULL COMMENT '用户id',
    `count`          INT(11) DEFAULT '0' COMMENT '数量',
    `money`          INT(11) DEFAULT '0' COMMENT '商品金额',
    `create_time`    DATETIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

CREATE DATABASE guli_stock;
USE guli_stock;
CREATE TABLE `t_stock`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `product_id`     VARCHAR(255) DEFAULT NULL,
    `title`          VARCHAR(255) DEFAULT NULL,
    `count`          INT(11) DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_product_id` (`product_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
-- 初始化测试数据
INSERT INTO t_stock(product_id,title , COUNT) VALUES( '1001' , '卫龙辣条' , 1000);

DELETE FROM t_order WHERE user_id = 9527;