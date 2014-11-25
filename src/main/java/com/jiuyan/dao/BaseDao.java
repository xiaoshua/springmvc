package com.jiuyan.dao;

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * Created by xiaoshua on 2014/11/18.
 */
public abstract class BaseDao {

    @Resource
    public SqlSessionTemplate sqlSession;
}
