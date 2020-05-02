package com.cj.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caijun
 * @Classname JdbcTest
 * @Description Jdbc CRUD
 * @Version 1.0
 * @create 2020-05-02 21:04
 */


public class JdbcTest {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    /**
     * Running before test method, Load resources
     */
    @Before
    public void before() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vhr", "root", "root");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryUser() {
        try {
            // step1: Load Driver  -->  Have done in before method

            // step2: Get database connection  -->  Have done in before method

            // step3: Create statement
            String sql = "SELECT * FROM hr";
            pstmt = conn.prepareStatement(sql);

            // step4: Execute
            rs = pstmt.executeQuery();


            // step5: Handle result  -->  Get result by reflect
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            Class<?> clzHr = Class.forName("com.cj.jdbc.Hr");

            List<Object> results = new ArrayList<>();
            while (rs.next()) {

                // step5-1: New resultType instance
                Object instanceHr = clzHr.newInstance();

                for (int i = 1; i <= columnCount; i++) {
                    // step5-2: Get columNname
                    String columnName = rsmd.getColumnName(i);

                    // step5-3: Get instance field by columName
                    Field field = clzHr.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(instanceHr, rs.getObject(columnName));
                }
                results.add(instanceHr);
            }

            for (Object obj : results) {
                System.out.println(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddUser() {
        try {
            // step1: Load Driver  -->  Have done in before method

            // step2: Get database connection  -->  Have done in before method

            // step3: Create statement
            String sql = "INSERT INTO hr(name,phone,telephone,address,enabled,username,password,userface,remark) " +
                    "VALUE ('张三','18072947787','0571-46238123','杭州','1','caijun2','sdfkjsdlkf','111','2222')";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // step4: Execute
            if (pstmt.executeUpdate() > 0) {
                System.out.println("sql更新成功！");
            } else {
                System.out.println("sql更新失败");
            }

            rs = pstmt.getGeneratedKeys();

            // step5: Get insert hr id
            List<Integer> keys = new ArrayList<>();
            while (rs.next()) {
                keys.add(rs.getInt(1));
            }

            for (Object obj : keys) {
                System.out.println(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Running after in test method, Close resources
     */
    @After
    public void after() {
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
}
