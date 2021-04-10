学习笔记

cluster集群配置

1.分别配置每个节点的集群开关和端口号，启动6个redis节点，集群配置如下

#开启集群模式

cluster-enabled yes

#保存节点配置,自动创建,自动更新(建议命名时加上端口号)

cluster-config-file nodes-6387.conf

#集群超时时间，节点超过这个时间没反应就断定是宕机

cluster-node-timeout 15000

#指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能会在断电时导致一段时间内的数据丢失。 yes表示：存储方式，aof，将写操作记录保存到日志中

appendonly yes

2.下载ruby，redis-3.2.2.gem

3.命令启动

ruby redis-trib.rb create --replicas 1 127.0.0.1:6383 127.0.0.1:6384 127.0.0.1:6385 127.0.0.1:6386 127.0.0.1:6387 127.0.0.1:6388
