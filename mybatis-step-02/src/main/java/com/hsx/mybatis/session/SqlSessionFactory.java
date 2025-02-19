package com.hsx.mybatis.session;

/**
 * @description:
 * @author：何世兴，微信：MrHe1006
 * @date: 2025-02-19
 * @author:2372781727@qq.com
 */

public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}
