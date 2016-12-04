package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseMapper;
import com.rbac.jrapid.entity.platform.SysRoleMenu;
import org.springframework.stereotype.Component;

/**
* SysRoleMenu 角色菜单关系 持久层操作类
* Created by JRapid on 2016-11-30 16:40:54.
*/
@Component("SysRoleMenuMapper")
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu,Long> {

}