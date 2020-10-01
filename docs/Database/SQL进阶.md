# SQL
## 1.内连接
>内连接（Inner Join），是将一张表的每一条记录与另一张表的每一行记录进行比较，得到两张表匹配的记录集合。

![图片描述](http://img.mukewang.com/wiki/5e7303980941eebd02200149.jpg)

```sql
SELECT * FROM imooc_user INNER JOIN imooc_class ON imooc_user.class_id = imooc_class.id;
```

## 2. 外连接

> 外连接有些许不同，它并不要求两张表中的记录都能够匹配，即使没有匹配到也会保留数据，被保留全部数据的表被称为保留表。

> 外连接可以根据保留表来进一步分为：`左外连接`（左边的表数据会被保留），`右外连接`（右边的表数据会被保留）和`全连接`（两边的表均被保留）。

> 外连接没有隐式的连接方式，必须通过 Join 与 On 显式的指定连接方式和连接条件。

- ##  左外连接

> 左外连接（Left Outer Join），简称左连接（Left Join）;若 A 和 B 两表进行左外连接，会在结果中包含左表（即表 A）的所有记录，即使那些记录在右表B 没有符合连接条件相应的匹配记录，未匹配的记录会给予 NULL 填充。

![图片描述](http://img.mukewang.com/wiki/5e730461092cd30002200149.jpg)

```sql
SELECT username,class_name FROM imooc_user LEFT OUTER JOIN imooc_class ON imooc_user.class_id = imooc_class.id;
```

- ## 右外连接

> 右外连接（Right Outer Join），简称右连接（Right Join）;若 A 和 B 两表进行右外连接，会在结果中包含右表（即表 B）的所有记录，即使那些记录在左表 A 中没有符合连接条件相应的匹配记录，未匹配的记录会给予 NULL 填充。

![图片描述](http://img.mukewang.com/wiki/5e7304930944f95402200149.jpg)

```sql
SELECT class_name,username FROM imooc_user RIGHT OUTER JOIN imooc_class ON imooc_class.id = imooc_user.class_id;
```

## 3.Group By & Having

> `Group By` 用于数据分组，一般与聚合函数一起使用，对分组后的数据进行聚合操作。由于 Where 无法与聚合函数一起搭配使用，因此 SQL 增加`Having` 指令。

Group By 提供了分组功能对数据分门别类，Having 可以与聚合函数搭配用于筛选数据。

```sql
SELECT age, COUNT(*) FROM imooc_user GROUP BY age;
```

> `COUNT(*)`在数据库层面有专门的优化，其性能跟`COUNT(1)`大致相同.

Having 不能单独出现，须于聚合函数搭配使用，且常与 Group By 一起出现。Having 本身并无其他含义，它的主要功能是替代 Where。

```sql
SELECT age, COUNT(*) FROM imooc_user GROUP BY age HAVING COUNT(*) > 1;
```

## 4. 子查询

子查询虽然很灵活，但是也有一定的限制，它必须满足以下几个规则：

1. 子查询必须在括号（）内。
2. 子查询中不能使用 Order By，主查询可以使用。
3. 子查询不能使用在聚合函数中。
4. Between 指令不能与子查询一起使用，但可使用在子查询内部。
5. 子查询若返回一条记录，则只能使用单值运算符，如 > ，若返回多条记录需使用多值运算符，如 In。
6. 若子查询返回多条记录，且使用 ANY 或 ALL 特殊语法，则可使用单值比较符，我们将在下小节介绍。

