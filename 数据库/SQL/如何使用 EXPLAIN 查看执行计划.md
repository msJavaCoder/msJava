## 如何使用 EXPLAIN 查看执行计划

```sql
explain select * from tb_blog
```

![image-20200704162403732](C:\Users\孙白胖的爸爸\AppData\Roaming\Typora\typora-user-images\image-20200704162403732.png)

数据表的访问类型所对应的 type 列是我们比较关注的信息。type 可能有以下几种情况：

![image-20200704162231322](C:\Users\孙白胖的爸爸\AppData\Roaming\Typora\typora-user-images\image-20200704162231322.png)

在这些情况里，all 是最坏的情况，因为采用了全表扫描的方式。index 和 all 差不多，只不过 index 对索引表进行全扫描，这样做的好处是不再需要对数据进行排序，但是开销依然很大。如果我们在 extra 列中看到 Using index，说明采用了索引覆盖，也就是索引可以覆盖所需的 SELECT 字段，就不需要进行回表，这样就减少了数据查找的开销。

range 表示采用了索引范围扫描，这里不进行举例，从这一级别开始，索引的作用会越来越明显，因此我们需要尽量让 SQL 查询可以使用到 range 这一级别及以上的 type 访问方式。

index_merge 说明查询同时使用了两个或以上的索引，最后取了交集或者并集。

