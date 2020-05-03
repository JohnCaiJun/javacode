# javacode
Java code practice

## 持久层
### JDBC

手写jdbc流程

目标：将jdbc流程烂熟于心

### Mybatis
#### Mybatis 核心
一、mybatis框架原理分析
 1. 接口层（SqlSession接口）
 2. 数据处理层（输入映射、输出 映射、SQL解析、SQL映射、SQL执行）
 3. 基础支撑层（连接管理、配置管理）

二、SqlSession执行流程分析
1. SqlSession创建流程（SqlSessionFactoryBuilder-->SqlSessionFactory-->SqlSession）
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
