学习笔记

Q1：按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率

PreparedStatement批量插入，测试耗时12秒6(设置rewriteBatchedStatements=true时，批量提交速度显著提升，=false时非常慢)

csv文件导入，测试耗时1分21秒

运行sql文件，测试耗时1分55秒

Q2:实现读写分离1.0&2.0
V1.0,mysql项目下的test
V2.0,shardingsphere项目下的test

