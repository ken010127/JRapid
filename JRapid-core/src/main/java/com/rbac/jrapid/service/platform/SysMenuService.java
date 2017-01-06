package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dto.request.platform.SysMenuRequest;
import com.rbac.jrapid.dto.response.platform.SysMenuResponse;
import com.rbac.jrapid.entity.platform.SysMenu;

import java.util.List;

/**
* 逻辑处理接口
* Created by JRapid on 2016-9-4 18:23:09
*/
public interface SysMenuService {

    SysMenu findOne(Long id) throws Exception;

    SysMenuResponse save(SysMenu sysMenu) throws Exception;

    SysMenuResponse update(SysMenu sysMenu) throws Exception;

    SysMenuResponse updateSelected(SysMenu sysMenu, java.util.List<String> list) throws Exception;

    SysMenuResponse delete(Long id) throws Exception;

    java.util.List<SysMenu> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

    /**
     * 获取树结构菜单列表
     * @return 菜单列表
     */
    List<SysMenu> getMenuTree();

    /**
     * 保存菜单配置信息
     * @param request 请求数据
     * @return
     */
    SysMenuResponse saveMenuConfig(SysMenuRequest request) throws Exception;

    /**
     * 查询菜单配置信息
     * @param menuId 菜单ID
     * @return 菜单配置信息
     * @throws Exception
     */
    SysMenuResponse getMenuConfigInfo(Long menuId) throws Exception;
}
