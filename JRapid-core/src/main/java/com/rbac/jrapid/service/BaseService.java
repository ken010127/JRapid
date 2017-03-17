package com.rbac.jrapid.service;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.core.common.dao.Page;
import com.rbac.jrapid.core.dto.response.BaseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * @author FWJ
 * @since 2017/3/13 下午3:20
 */
public interface BaseService<T> {

    T findOne(Serializable id) throws Exception;

    List<T> findAll() throws Exception;

    BaseResponse<T> save(T t) throws Exception;

    BaseResponse<T> update(T t) throws Exception;

    BaseResponse<T> saveOrUpdate(T t) throws Exception;

    BaseResponse<T> updateSelected(T t, java.util.List<String> list) throws Exception;

    BaseResponse<T> delete(Serializable id) throws Exception;

    List<T> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

    Page<T> pageQuery(Page page);
}
