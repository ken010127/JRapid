package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysMenu;

import java.util.List;

/**
* 逻辑处理接口
* Created by JRapid on 2016-9-4 18:23:09
*/
public interface SysMenuService {

    SysMenu findOne(Long id) throws Exception;

    int save(SysMenu sysMenu) throws Exception;

    int update(SysMenu sysMenu) throws Exception;

    int updateSelected(SysMenu sysMenu, java.util.List<String> list) throws Exception;

    int delete(Long id) throws Exception;

    java.util.List<SysMenu> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

    /**
     * 获取树结构菜单列表
     * @return 菜单列表
     */
    List<SysMenu> getMenuTree();
}
