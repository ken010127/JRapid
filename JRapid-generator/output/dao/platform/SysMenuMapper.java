package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.core.common.dao.BaseDao;
import com.rbac.jrapid.entity.platform.SysMenu;
import org.springframework.stereotype.Component;

/**
* SysMenu  持久层操作类
* Created by JRapid on 2016-9-4 18:22:36.
*/
@Component("SysMenuMapper")
public interface SysMenuMapper extends BaseDao<SysMenu,Long> {

}