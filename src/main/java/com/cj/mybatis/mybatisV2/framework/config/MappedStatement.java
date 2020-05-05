package com.cj.mybatis.mybatisV2.framework.config;

import com.cj.mybatis.mybatisV2.framework.sqlsource.iface.SqlSource;

/**
 * @author caijun
 * @Classname MappedStatement
 * @Description
 * @Version 1.0
 * @create 2020-05-05 11:31
 */


public class MappedStatement {
    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public SqlSource getSqlSource() {
        return sqlSource;
    }

    public void setSqlSource(SqlSource sqlSource) {
        this.sqlSource = sqlSource;
    }

    public String getGetStatementType() {
        return getStatementType;
    }

    public void setGetStatementType(String getStatementType) {
        this.getStatementType = getStatementType;
    }

    public Class<?> getParameterTypeClass() {
        return parameterTypeClass;
    }

    public void setParameterTypeClass(Class<?> parameterTypeClass) {
        this.parameterTypeClass = parameterTypeClass;
    }

    public Class<?> getResultTypeClass() {
        return resultTypeClass;
    }

    public void setResultTypeClass(Class<?> resultTypeClass) {
        this.resultTypeClass = resultTypeClass;
    }

    private String statementId;
    private SqlSource sqlSource;

    private String getStatementType;
    private Class<?> parameterTypeClass;
    private Class<?> resultTypeClass;
}
