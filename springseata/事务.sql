# 事务相关命令
#查看mysql所有的[全局|会话]系统变量
# SHOW [GLOBAL|SESSION] VARIABLES;
SHOW GLOBAL VARIABLES;
#模糊查询[全局|会话]系统变量
# show [GLOBAL|SESSION] variables like '变量名';
#查看全局系统变量
# SELECT @@变量名;

# 查看本次会话事务隔离级别
SELECT @@transaction_isolation;

