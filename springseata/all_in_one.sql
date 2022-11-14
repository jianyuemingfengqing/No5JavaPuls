# Account
DROP SCHEMA IF EXISTS db_account;
CREATE SCHEMA db_account;
USE db_account;

CREATE TABLE `account_tbl`
(
    `id`      INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` VARCHAR(255) DEFAULT NULL,
    `money`   INT(11)      DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `log_tbl` (
  `id` char(20) NOT NULL,
  `order_id` char(20) NOT NULL,
  `money` int NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO account_tbl (id, user_id, money)
VALUES (1, '1001', 10000);
INSERT INTO account_tbl (id, user_id, money)
VALUES (2, '1002', 10000);

# Order
DROP SCHEMA IF EXISTS db_order;
CREATE SCHEMA db_order;
USE db_order;

CREATE TABLE `order_tbl`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `user_id`        VARCHAR(255) DEFAULT NULL,
    `commodity_code` VARCHAR(255) DEFAULT NULL,
    `count`          INT(11)      DEFAULT '0',
    `money`          INT(11)      DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# Storage
DROP SCHEMA IF EXISTS db_storage;
CREATE SCHEMA db_storage;
USE db_storage;

CREATE TABLE `storage_tbl`
(
    `id`             INT(11) NOT NULL AUTO_INCREMENT,
    `commodity_code` VARCHAR(255) DEFAULT NULL,
    `count`          INT(11)      DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `commodity_code` (`commodity_code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO storage_tbl (id, commodity_code, count)
VALUES (1, '2001', 1000);
