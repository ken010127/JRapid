package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.entity.platform.SysButton;

import java.util.List;

/**
* 按钮管理逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysButtonService {

    SysButton findOne(Long id) throws Exception;

    Integer save(SysButton sysButton) throws Exception;

    Integer update(SysButton sysButton) throws Exception;

    Integer saveOrUpdate(SysButton sysButton) throws Exception;

    Integer updateSelected(SysButton sysButton, java.util.List<String> list) throws Exception;

    Integer delete(Long id) throws Exception;

    java.util.List<SysButton> listByCondition(CommonExample commonExample) throws Exception;

    Integer countByCondition(CommonExample commonExample) throws Exception;

    /**
     * 根据某个菜单下的按钮
     * @param menuId
     * @return
     * @throws Exception
     */
    List<SysButton> queryButtonByMenuId(Long menuId) throws Exception;

    Integer deleteByMenuId(Long menuId) throws Exception;

}
