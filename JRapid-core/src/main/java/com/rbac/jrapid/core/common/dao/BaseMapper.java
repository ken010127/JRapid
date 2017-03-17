package com.rbac.jrapid.core.common.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * DAO操作基础类
 * @author FWJ
 * Created on 2016/8/23 20:27
 */
public interface BaseMapper<T> {

    List<T> findAll() throws java.lang.Exception;

    List<T> pageQuery(@Param("page") Page<T> page);

    T findOne(Serializable id) throws java.lang.Exception;

    int save(T t) throws java.lang.Exception;

    int update(T t) throws java.lang.Exception;

    int delete(Serializable id) throws java.lang.Exception;

    int updateSelected(@org.apache.ibatis.annotations.Param("record") T t, @org.apache.ibatis.annotations.Param("columns") java.util.List<java.lang.String> list) throws java.lang.Exception;

    java.util.List<T> listByCondition(@org.apache.ibatis.annotations.Param("example") CommonExample commonExample) throws java.lang.Exception;

    java.lang.Integer countByCondition(@org.apache.ibatis.annotations.Param("example") CommonExample commonExample) throws java.lang.Exception;
}
