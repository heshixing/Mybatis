package com.hsx.mybatis.test;

import com.hsx.mybatis.builder.xml.XMLConfigBuilder;
import com.hsx.mybatis.io.Resources;
import com.hsx.mybatis.session.Configuration;
import com.hsx.mybatis.session.SqlSession;
import com.hsx.mybatis.session.SqlSessionFactory;
import com.hsx.mybatis.session.SqlSessionFactoryBuilder;
import com.hsx.mybatis.session.defaults.DefaultSqlSession;
import com.hsx.mybatis.test.dao.IUserDao;
import com.hsx.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import com.hsx.mybatis.builder.xml.XMLConfigBuilder;
import com.hsx.mybatis.io.Resources;
import com.hsx.mybatis.session.Configuration;
import com.hsx.mybatis.session.SqlSession;
import com.hsx.mybatis.session.SqlSessionFactory;
import com.hsx.mybatis.session.SqlSessionFactoryBuilder;
import com.hsx.mybatis.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;


public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

    @Test
    public void test_selectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("com.hsx.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }

}