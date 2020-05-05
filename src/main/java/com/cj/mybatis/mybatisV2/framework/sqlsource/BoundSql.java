package com.cj.mybatis.mybatisV2.framework.sqlsource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caijun
 * @Classname BoundSql
 * @Description
 *
 * 存储了select/update/delete/insert标签内SQL语句最终被处理之后的SQL,
 * 也就是JDBC可以直接执行的SQL语句
 *
 * @Version 1.0
 * @create 2020-05-05 11:47
 */


public class BoundSql {
    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void addParameterMapping(ParameterMapping parameterMapping) {
        this.parameterMappings.add(parameterMapping);
    }

    // JDBC可以执行的SQL语句 ： SELECT * FROM User WHERE username = ? AND sex = ?
    private String sql;

    // 占位符？对应的参数信息：参数名称和类型   ==> 利用反射获取执行sql后的结果集中的内容
    private List<ParameterMapping> parameterMappings = new ArrayList<>();


}
