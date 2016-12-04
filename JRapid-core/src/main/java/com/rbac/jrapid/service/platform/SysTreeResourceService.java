package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysTreeResource;

/**
* 树资源信息，管理树机构的表信息逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysTreeResourceService {

    SysTreeResource findOne(Long id) throws Exception;

    Integer save(SysTreeResource sysTreeResource) throws Exception;

    Integer update(SysTreeResource sysTreeResource) throws Exception;

    Integer updateSelected(SysTreeResource sysTreeResource, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysTreeResource> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
