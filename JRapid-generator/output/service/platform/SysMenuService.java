package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysMenu;

/**
* 逻辑处理接口
* Created by JRapid on 2016-9-4 18:23:09
*/
public interface SysMenuService {

    SysMenu findOne(Long id) throws java.lang.Exception;

    Integer save(SysMenu sysMenu) throws java.lang.Exception;

    Integer update(SysMenu sysMenu) throws java.lang.Exception;

    Integer updateSelected(SysMenu sysMenu, java.util.List<java.lang.String> list) throws java.lang.Exception;

    Integer delete(Long id) throws java.lang.Exception;

    java.util.List<SysMenu> listByCondition(CommonExample commonExample) throws java.lang.Exception;

    java.lang.Integer countByCondition(CommonExample commonExample) throws java.lang.Exception;

}
