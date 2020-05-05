package com.cj.mybatis.mybatisV2.framework.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caijun
 * @Classname Configuration
 * @Description
 * @Version 1.0
 * @create 2020-05-05 11:26
 */


public class Configuration {
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MappedStatement getMappedStatementById(String statementId) {
        return mappedStatements.get(statementId);
    }

    public void addMappedStatement(String statementId, MappedStatement mappedStatement) {
        this.mappedStatements.put(statementId, mappedStatement);
    }

    private DataSource dataSource;
    private Map<String, MappedStatement> mappedStatements = new HashMap<>();

}
