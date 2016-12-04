package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysUserRole;

/**
* 用户角色关系逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysUserRoleService {

    SysUserRole findOne(Long id) throws Exception;

    Integer save(SysUserRole sysUserRole) throws Exception;

    Integer update(SysUserRole sysUserRole) throws Exception;

    Integer updateSelected(SysUserRole sysUserRole, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysUserRole> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
