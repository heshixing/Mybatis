package com.hsx.mybatis.builder;

import com.hsx.mybatis.session.Configuration;
import com.hsx.mybatis.type.TypeAliasRegistry;
import com.hsx.mybatis.session.Configuration;
import com.hsx.mybatis.type.TypeAliasRegistry;

/**
 * @author 小傅哥，微信：fustack
 * @description 构建器的基类，建造者模式
 * @date 2022/04/06
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
