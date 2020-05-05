package com.cj.mybatis.mybatisV2.framework.sqlsource;

/**
 * @author caijun
 * @Classname ParameterMapping
 * @Description
 *
 *  主要用来解析#{} 时获取的参数名称和类型
 *
 * @Version 1.0
 * @create 2020-05-05 11:53
 */


public class ParameterMapping {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    // #{} 参数名称
    private String name;

    // 参数类型
    private Class<?> type;
}
