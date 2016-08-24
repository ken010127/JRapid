package com.rbac.jrapid.core.common.dao;

/**
 * DAO操作基础类
 * @author FWJ
 * Created on 2016/8/23 20:27
 */
public interface BaseDao<T, P> {
    T findOne(P p) throws java.lang.Exception;

    int save(T t) throws java.lang.Exception;

    int insertWithSequence(T t) throws java.lang.Exception;

    int update(T t) throws java.lang.Exception;

    int delete(P p) throws java.lang.Exception;

    int updateSelected(@org.apache.ibatis.annotations.Param("record") T t, @org.apache.ibatis.annotations.Param("columns") java.util.List<java.lang.String> list) throws java.lang.Exception;

    java.util.List<T> listByCondition(@org.apache.ibatis.annotations.Param("example") CommonExample commonExample) throws java.lang.Exception;

    java.lang.Integer countByCondition(@org.apache.ibatis.annotations.Param("example") CommonExample commonExample) throws java.lang.Exception;
}
