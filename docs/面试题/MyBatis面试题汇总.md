# 👉 MyBatis

#### MyBatis 重要组件

- Mapper 配置：用于组织具体的查询业务和映射数据库的字段关系，可以使用 XML 格式或 Java 注解格式来实现；
- Mapper 接口：数据操作接口也就是通常说的 DAO 接口，要和 Mapper 配置文件中的方法一一对应；
- Executor：MyBatis 中所有的 Mapper 语句的执行都是通过 Executor 执行的；
- SqlSession：类似于 JDBC 中的 Connection，可以用 SqlSession 实例来直接执行被映射的 SQL 语句；
- SqlSessionFactory：SqlSessionFactory 是创建 SqlSession 的工厂，可以通过 SqlSession openSession() 方法创建 SqlSession 对象。

#### MyBatis 执行流程

MyBatis 完整执行流程如下图所示：

![1](https://images.gitbook.cn/4070e4c0-da75-11e9-b7a4-5f21fd84c626)

MyBatis 执行流程说明：

1. 首先加载 Mapper 配置的 SQL 映射文件，或者是注解的相关 SQL 内容。
2. 创建会话工厂，MyBatis 通过读取配置文件的信息来构造出会话工厂（SqlSessionFactory）。
3. 创建会话，根据会话工厂，MyBatis 就可以通过它来创建会话对象（SqlSession），会话对象是一个接口，该接口中包含了对数据库操作的增、删、改、查方法。
4. 创建执行器，因为会话对象本身不能直接操作数据库，所以它使用了一个叫做数据库执行器（Executor）的接口来帮它执行操作。
5. 封装 SQL 对象，在这一步，执行器将待处理的 SQL 信息封装到一个对象中（MappedStatement），该对象包括 SQL 语句、输入参数映射信息（Java 简单类型、HashMap 或 POJO）和输出结果映射信息（Java 简单类型、HashMap 或 POJO）。
6. 操作数据库，拥有了执行器和 SQL 信息封装对象就使用它们访问数据库了，最后再返回操作结果，结束流程。

