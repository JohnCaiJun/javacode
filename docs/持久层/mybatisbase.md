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

#### 全局配置文件

mybatis-config.xml 配置的内容和顺序：

1. properties（属性） 
2. settings（全局配置参数） 
3. typeAliases（类型别名） 
4. typeHandlers（类型处理器）--Java类型--JDBC类型--->数据库类型转换 
5. objectFactory（对象工厂） 
6. plugins（插件）--可以在Mybatis执行SQL语句的流程中，横叉一脚去实现一些功能增强，比如 PageHelper分页插件，就是第三方实现的一个插件 
7. environments（环境集合属性对象） 
8. environment（环境子属性对象） 
9. transactionManager（事务管理） 
10. dataSource（数据源） 
11. mappers（映射器）


properties:

```xml
<properties>
    <property name="key" value=""/>
</properties>

<!--or-->

<properties resources="db.properties"/>

```

typeAliases:

```xml
<typeAliases>
    <typeAlias alias="Hr" type="com.cj.mybatis.mybatisbase.phase02.domain.Hr"
</typeAliases>
```

mappers

```xml
<!--注册指定包下所有mapper接口，来加载映射文件-->
<package name="com.cj.mybatis.mybatisbase.phase02.mapper"/>

<!--指定resources路径下的配置文件-->
<package resources="mybatisbase/phase02/HrMapper.xml"/>

```

#### parameterType 输入类型
parameterType属性可以映射的输入参数Java类型有：简单类型、POJO类型、Map类型、List类型（数组）

> Map类型和POJO类型的用法类似

##### 传递简单类型

```xml
<!--映射文件-->
<select id="findHrById" resultType="com.cj.mybatis.mybatisbase.phase02.domain.Hr" parameterType="java.lang.String">
    select * from Hr where name like '%${value}%'
</select>

<!--mapper接口-->
public List<Hr> findHrByName(String name) throws Exception;
```

> #{} 与 ${} 的区别
>> 1.#{} 会进行转换  比如参数传递字符串：username  会转换为  'username', 而 ${} 则会直接进行替换 username
>>
>> 2.如果进行简单类型的输入映射，#{}参数名称可以任意，而${}必须是value
>>
>> 3.${}存在SQL注入问题 （使用OR 1=1 关键字将查询条件忽略）(PrepareStatement)
>>
>> 4.#{} 相当于JDBC SQL语句中的占位符，${}相当于JDBC SQL语句中的连接符号+ （statement）


##### 传递POJO对象
需求：添加用户，并返回主键
```xml
<!--映射文件-->
<insert id="insertHr" parameterType="Hr">
    <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Integer">
     select LAST_INSERT_ID()
    </selectKey>
    INSERT INTO Hr(name,birthday,sex,address)
    VALUES(#{name},#{birthday},#{sex},#{address});

</insert>

```

#### resultType 输出类型

resultType属性可以映射的Java类型有：简单类型、POJO类型、Map类型

> 注意：输出简单类型必须查出来的结果只有一列

##### reusltMap

如果sql查询列名和pojo的属性名可以不一致，通过resultMap将列名和属性名作一个对应关系，最终将
查询结果映射到指定的pojo对象中。

>注意：resultType底层也是通过resultMap完成映射的。

需求: 将以下sql结果进行映射

`SELECT id id_,username username_,birthday birthday_ FROM user`

mapper接口：

`public List<User> findUserListResultMap() throws Exception;`

映射文件
```xml
<resultMap type="user" id="userListResultMap"> 
    <!-- id标签：映射查询结果的唯一列（主键列） column：查询sql的列名 property：映射结果的属性名 --> 
    <id column="id_" property="id"/> 
    <!-- result标签：映射查询结果的普通列 --> 
    <result column="username_" property="username"/> 
    <result column="birthday_" property="birthday"/> 
</resultMap>
 
<!-- resultMap入门 -->
<select id="findUserListResultMap" resultMap="userListResultMap">
 SELECT id id_,username username_,birthday birthday_ FROM user 
</select>

```

#### 关联查询

POJO对象

```java
public class Orders{
    private User user;
    private List<User> users;
}
```

一对一：association 标签




映射文件

```xml

<resultMap>
    <association property="user" javaType="com.cj.User">
        <id column="id" property="id"/>
        <result column="username" property="username"/>
    </association>
</resultMap>

```

一对多：

映射文件

```xml

<resultMap>
    <collection property="user" ofType="com.cj.User">
        <id column="id" property="id"/>
        <result column="username" property="username"/>
    </collection>
</resultMap>
```