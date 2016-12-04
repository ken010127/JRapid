package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysOrg;

/**
* 组织架构逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysOrgService {

    SysOrg findOne(Long id) throws Exception;

    Integer save(SysOrg sysOrg) throws Exception;

    Integer update(SysOrg sysOrg) throws Exception;

    Integer updateSelected(SysOrg sysOrg, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysOrg> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
