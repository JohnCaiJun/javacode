package com.cj.mybatis.mybatisbase.phase01;

import com.cj.mybatis.mybatisbase.phase01.dao.HrDao;
import com.cj.mybatis.mybatisbase.phase01.dao.HrDaoImpl;
import com.cj.mybatis.mybatisbase.phase01.domain.Hr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author caijun
 * @Classname Test01
 * @Description
 * @Version 1.0
 * @create 2020-05-05 13:48
 */


public class Test01 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // setp1: 加载全局配置文件
        String resource = "mybatisbase/phase01/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // step2: Generate sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }


    @Test
    public void testFindHrByiId(){
        HrDao hrDao = new HrDaoImpl(sqlSessionFactory);
        Hr hr = hrDao.findHrById(5);
        System.out.println(hr);
    }
}
