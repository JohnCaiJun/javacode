package com.cj.mybatis.mybatisbase.phase02;

import com.cj.mybatis.mybatisbase.phase02.domain.Hr;
import com.cj.mybatis.mybatisbase.phase02.mapper.HrMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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


public class Test02 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // setp1: 加载全局配置文件
        String resource = "mybatisbase/phase02/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // step2: Generate sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }


    @Test
    public void testFindHrByiId(){
        // step1: 创建HrMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HrMapper mapper = sqlSession.getMapper(HrMapper.class);

        // step2: 调用HrMapper对象中的API
        Hr hr= mapper.findHrById(5);
        System.out.println(hr);
    }
}
