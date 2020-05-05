package com.cj.mybatis.mybatisbase.phase01.dao;

import com.cj.mybatis.mybatisbase.phase01.domain.Hr;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author caijun
 * @Classname HrDaoImpl
 * @Description
 * @Version 1.0
 * @create 2020-05-05 13:36
 */


public class HrDaoImpl implements HrDao {
    private SqlSessionFactory sqlSessionFactory;


    public HrDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Hr findHrById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Hr hr = sqlSession.selectOne("test.findHrById", id);
        return hr;
    }
}
