package com.cj.mybatis.mybatisV2.framework.sqlsource.iface;

import com.cj.mybatis.mybatisV2.framework.sqlsource.BoundSql;

/**
 * 提供对select/update/delete/insert标签内的SQL的处理
 */

public interface SqlSource {
    /**
     * 解析SqlSource实现类存储的SQL信息
     *   #{} : preparedStatement处理方式 --> 占位符
     *   ${} : Statement的处理方式 --> 字符串拼接
     * @param param
     * @return
     */
   BoundSql getBoundSql(Object param);
}
