package com.cj.mybatis.mybatisV2;

import com.cj.mybatis.mybatisV2.framework.config.Configuration;
import com.cj.mybatis.mybatisV2.framework.config.MappedStatement;
import com.cj.mybatis.mybatisV2.framework.sqlsource.BoundSql;
import com.cj.mybatis.mybatisV2.framework.sqlsource.ParameterMapping;
import com.cj.mybatis.mybatisV2.framework.sqlsource.iface.SqlSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caijun
 * @Classname MybatisV2
 * @Description 1. properties 配置文件升级为XML配置文件
 * 2. 使用面向过程改造代码
 * @Version 1.0
 * @create 2020-05-05 11:19
 */


public class MybatisV2 {
    private Configuration configuration = new Configuration();


    @Test
    public void test() {
        // step1: Load configuration
        loadConfiguration();


        // step2: Set parameter value
        Map<String, Object> params = new HashMap<>();
        params.put("name", "张三");


        // step3: Call select method
        List<Object> results = selectList("selectUserById", params);


        // step4: Handle result
        for (Object obj : results) {
            System.out.println(obj);
        }


    }

    private List<Object> selectList(String statementId, Object params) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Object> results = new ArrayList<>();
        try {
            // step1: Get connection
            conn = getConnection();


            // step2: Create statement  --> 最终得到解析过后的SQL
            // step2-1: 先获取MappedStatement
            MappedStatement mappedStatement = configuration.getMappedStatementById(statementId);
            // step2-2: 再获取MappedStatement中的sqlSource
            SqlSource sqlSource = mappedStatement.getSqlSource();
            // step2-3: 再通过SqlSource得到BoundSql --> (getBoundSql方法还没有处理)
            BoundSql boundSql = sqlSource.getBoundSql(params);
            // step2-4: 通过BoundSql获取SQL
            String sql = boundSql.getSql();

            pstmt = conn.prepareStatement(sql);


            // step3: Set params
            setPrameters(statementId, params, pstmt, boundSql);

            // step4: Execute sql
            rs = pstmt.executeQuery();

            // step5: Handle results
            handleResultSet(rs,results,mappedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;

    }

    private void handleResultSet(ResultSet rs, List<Object> results, MappedStatement mappedStatement) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> resultTypeClass = mappedStatement.getResultTypeClass();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        while (rs.next()) {
            Object resultInstance = resultTypeClass.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                Field field = resultTypeClass.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(resultInstance, rs.getObject(columnName));
            }
            results.add(resultInstance);
        }
    }

    private void setPrameters(String statementId, Object params, PreparedStatement pstmt, BoundSql boundSql)
            throws SQLException {
        if (params.getClass().isPrimitive() || params.getClass() == String.class) {
            pstmt.setObject(1, params);
        } else {
            // step1: Get parameter name and type
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();

            Map mParams = (Map) params;
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                String paramName = parameterMapping.getName();
                Object paramValue = mParams.get(paramName);
                if (paramValue == null) {
                    System.out.println("Please set param <<" + paramName + ">> in jdbc.properties");
                    System.exit(1);
                } else {
                    pstmt.setObject(i + 1, paramValue);
                }
            }
        }
    }

    private Connection getConnection() {
        DataSource dataSource = configuration.getDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void loadConfiguration() {
    }


}
