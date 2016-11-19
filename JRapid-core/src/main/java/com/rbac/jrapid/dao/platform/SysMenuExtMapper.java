package com.rbac.jrapid.dao.platform;

import com.rbac.jrapid.entity.platform.SysMenu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* SysMenu  持久层扩展操作类
* Created by JRapid on 2016-9-4 18:17:01.
*/
@Component("SysMenuExtMapper")
public interface SysMenuExtMapper{

    /**
     * 获取菜单根节点
     * @return 跟节点菜单
     */
    List<SysMenu> getRoots();

}