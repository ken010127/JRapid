package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysDictionary;

/**
* 数据字典逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysDictionaryService {

    SysDictionary findOne(Long id) throws Exception;

    Integer save(SysDictionary sysDictionary) throws Exception;

    Integer update(SysDictionary sysDictionary) throws Exception;

    Integer updateSelected(SysDictionary sysDictionary, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysDictionary> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
