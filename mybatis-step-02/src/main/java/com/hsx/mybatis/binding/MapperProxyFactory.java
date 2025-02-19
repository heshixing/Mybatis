package com.hsx.mybatis.binding;

import com.hsx.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author：何世兴，微信：MrHe1006
 * @date: 2025-02-19
 * @author:2372781727@qq.com
 */

public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}
