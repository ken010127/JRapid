package com.rbac.jrapid.service.platform;

import com.rbac.jrapid.entity.platform.SysButton;
import com.rbac.jrapid.service.BaseService;

import java.util.List;

/**
* 按钮管理逻辑处理接口
* Created by JRapid on 2016-11-30 16:29:53
*/
public interface SysButtonService extends BaseService<SysButton>{

    /**
     * 根据某个菜单下的按钮
     * @param menuId
     * @return
     * @throws Exception
     */
    List<SysButton> queryButtonByMenuId(Long menuId) throws Exception;

    Integer deleteByMenuId(Long menuId) throws Exception;

}
