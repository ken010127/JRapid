package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysRole;

/**
* 角色管理逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysRoleService {

    SysRole findOne(Long id) throws Exception;

    Integer save(SysRole sysRole) throws Exception;

    Integer update(SysRole sysRole) throws Exception;

    Integer updateSelected(SysRole sysRole, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysRole> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
