package com.cj.mybatis.mybatisV1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @author caijun
 * @Classname MybatisV1
 * @Description 封装jdbc，解决硬编码的问题
 * <p>
 * The core process
 * 1.Load configuration
 * 2.Passing parameters
 * 3.Call the select method
 * @Version 1.0
 * @create 2020-05-03 09:48
 */


public class MybatisV1 {
    private Properties properties = null;

    @Test
    public void test() {
        // step1: Load configuration
        loadConfiguration();

        // step2: Setting params
        Map<String, Object> params = new HashMap<>();
        params.put("name", "李白");

        // step3: Get statementId
        String statementId = properties.getProperty("statementId");

        // step4: Call select method
        List<Object> results = selectList(statementId, params);

        // step5: Handle results
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
            // step1: Load driver
            Class.forName(properties.getProperty("driver"));

            // step2: Get connection
            conn = DriverManager.getConnection(properties.getProperty("jdbcUrl"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));

            // step3: Create statement
            pstmt = conn.prepareStatement(properties.getProperty("db.sql." + statementId));

            // step4: Get sql params name
            String sqlParams = properties.getProperty("db.params." + statementId);
            if (sqlParams.length() == 0) {
                // no params
                rs = pstmt.executeQuery();

            } else {
                // step5: Setting sql params value
                String[] paramsArray = sqlParams.split(",");
                Map mParams = (Map) params;
                for (int i = 0; i < paramsArray.length; i++) {
                    String paramName = paramsArray[i];
                    Object paramValue = mParams.get(paramName);
                    if (paramValue == null) {
                        System.out.println("Please set param <<" + paramName + ">> in jdbc.properties");
                        System.exit(1);
                    } else {
                        pstmt.setObject(i + 1, paramValue);
                    }
                }
                rs = pstmt.executeQuery();
            }

            // step6: Handle results
            Class<?> clzResultType = Class.forName(properties.getProperty("db.resultype." + statementId));
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                Object resultInstance = clzResultType.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    Field field = clzResultType.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(resultInstance, rs.getObject(columnName));
                }
                results.add(resultInstance);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    /**
     * Load configuration
     */
    private void loadConfiguration() {
        properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatisV1/jdbc.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
