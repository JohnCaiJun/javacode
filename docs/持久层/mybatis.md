
#### Mybatis 核心
一、mybatis框架原理分析
 1. 接口层（SqlSession接口）
 2. 数据处理层（输入映射、输出映射、SQL解析、SQL映射、SQL执行）
 3. 基础支撑层（连接管理、配置管理）

二、SqlSession执行流程分析
1. SqlSession创建流程（SqlSessionFactoryBuilder-->SqlSessionFactory-->SqlSession）----configuration对象
2. SqlSession执行流程（SqlSession-->Executor->StatementHandler-->ParameterHandler-->ResultSetHandler)

#### MybatisV1.0版本
JDBC存在的问题：
> 1.存在硬编码问题
>
> 2.频繁创建和释放数据连接

改造思路：
> 1.将代码中的硬编码问题，封装到properties文件
>
> 2.对jdbc进行简单的封装，通过properties文件加载配置信息，解决jdbc硬编码的问题


### MybatisV2.0版本
通过读取XMl配置文件，获取参数名称、参数类型、结果类型、sql语句

看图解析：
![Image](https://raw.githubusercontent.com/JohnCaiJun/img_storage/master/java/mybatis/Snipaste_2020-05-05_11-37-46.png)