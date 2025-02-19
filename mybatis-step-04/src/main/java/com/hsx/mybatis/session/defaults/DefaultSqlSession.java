package com.hsx.mybatis.session.defaults;

import com.hsx.mybatis.mapping.MappedStatement;
import com.hsx.mybatis.session.Configuration;
import com.hsx.mybatis.session.SqlSession;

/**
 * @description:
 * @author：何世兴，微信：MrHe1006
 * @date: 2025-02-19
 * @author:2372781727@qq.com
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
