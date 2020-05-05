### 编码流程
1. 编写全局配置文件： mybatis-config.xml（数据库配置等）
2. 映射文件： xxxMapper.xml （编写SQL语句）
3. 编写dao代码：xxxDao接口、xxxDaoImpl实现类（编写mybatis API）
4. POJO类 （用来传递参数和映射结果）


### 基于XML

开发方式：只需要开发Mapper接口（DAO接口）和Mapper映射文件，不需要编写实现类。

Mapper接口开发规范：
1. Mapper接口的类路径与Mapper.xml文件中的namespase相同
2. Mapper接口方法名称和Mapper.xml中定义的每个statement的id相同
3. Mapper接口方法的输入参数类型和mapper.xml中定义的每个sql的parameterType类型相同
4. Mapper接口方法的返回值类型和mapper.xml中定义的每个slq的resultType的类型相同


方法三要素：方法名称、方法参数、方法返回结果
 