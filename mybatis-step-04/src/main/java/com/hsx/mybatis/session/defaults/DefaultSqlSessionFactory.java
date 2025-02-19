package com.hsx.mybatis.session.defaults;

import com.hsx.mybatis.session.Configuration;
import com.hsx.mybatis.session.SqlSession;
import com.hsx.mybatis.session.SqlSessionFactory;

/**
 * @description:
 * @author：何世兴，微信：MrHe1006
 * @date: 2025-02-19
 * @author:2372781727@qq.com
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
