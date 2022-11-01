use springboot;
CREATE TABLE `tb_user` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` varchar(20) NOT NULL,
                           `gender` varchar(5) DEFAULT NULL,
                           `age` int(11) DEFAULT NULL,
                           `address` varchar(32) DEFAULT NULL,
                           `qq` varchar(20) DEFAULT NULL,
                           `email` varchar(50) DEFAULT NULL,
                           `username` varchar(20) NOT NULL,
                           `phone` varchar(11) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO tb_user1 VALUES (1,'黄蓉','女',38,'桃花岛','212223390222','huangrong222@qq.com','huangrong','15600003333'),(2,'黄老邪','男',58,'湖北省武汉市','212223390','huanglaoxie@qq.com','huanglaoxie','15872320405'),(3,'小龙女','男',18,'湖北省荆门市','212223390','xiaolongnv@qq.com','xiaolongnv','15600004444'),(7,'杨过','男',30,'扬州','212223390','yangguo@qq.com','yangguo','15600005555');
