package com.rbac.jrapid.service.impl;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.core.common.dao.Page;
import com.rbac.jrapid.core.common.utils.ReflectionUtils;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;
import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.core.exception.BaseException;
import com.rbac.jrapid.dto.response.platform.SysDictionaryResponse;
import com.rbac.jrapid.dto.response.platform.SysMenuResponse;
import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author FWJ
 * @since 2017/3/13 下午2:58
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> implements BaseService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public T findOne(Serializable id) throws Exception {
        return baseMapper.findOne(id);
    }

    @Override
    public List<T> findAll() throws Exception {
        return baseMapper.findAll();
    }

    @Override
    public BaseResponse<T> save(T entity) throws Exception {
        BaseResponse response = new BaseResponse();

        int result = baseMapper.save(entity);

        if (result<0){
            response.setStatus(false);
        }
        response.setEntity(entity);
        return response;
    }

    @Override
    public BaseResponse<T> update(T entity) throws Exception {
        BaseResponse response = new BaseResponse();
        int result = baseMapper.update(entity);
        if (result<0){
            response.setStatus(false);
        }
        response.setEntity(entity);
        return response;
    }

    @Override
    public BaseResponse<T> saveOrUpdate(T entity) throws Exception {
        List<Field> fields = ReflectionUtils.findFieldByAnnotation(entity.getClass(),PK.class);

        if (ReflectionUtils.invokeGetterMethod(entity,fields.get(0).getName()) == null){
            return this.save(entity);
        }else {
            return this.update(entity);
        }
    }

    @Override
    public BaseResponse<T> updateSelected(T entity, List<String> list) throws Exception {
        BaseResponse response = new BaseResponse();
        int result = baseMapper.updateSelected(entity,list);
        if (result<0){
            response.setStatus(false);
        }
        response.setEntity(entity);
        return response;
    }

    @Override
    public BaseResponse<T> delete(Serializable id) throws Exception {
        BaseResponse response = new BaseResponse();
        int result = baseMapper.delete(id);
        if (result<0){
            response.setStatus(false);
        }
        return response;
    }

    @Override
    public List<T> listByCondition(CommonExample commonExample) throws Exception {
        return baseMapper.listByCondition(commonExample);
    }

    @Override
    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return baseMapper.countByCondition(commonExample);
    }

    @Override
    public Page<T> pageQuery(Page page) {
        List<T> list = baseMapper.pageQuery(page);
        page.setResults(list);
        return page;
    }
}
