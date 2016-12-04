package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysRoleMenu;

/**
* 角色菜单关系逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysRoleMenuService {

    SysRoleMenu findOne(Long id) throws Exception;

    Integer save(SysRoleMenu sysRoleMenu) throws Exception;

    Integer update(SysRoleMenu sysRoleMenu) throws Exception;

    Integer updateSelected(SysRoleMenu sysRoleMenu, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysRoleMenu> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

}
