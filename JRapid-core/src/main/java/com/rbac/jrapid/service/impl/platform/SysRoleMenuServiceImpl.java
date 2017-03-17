package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysRoleMenuExtMapper;
import com.rbac.jrapid.dao.platform.SysRoleMenuMapper;
import com.rbac.jrapid.entity.platform.SysRoleMenu;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 角色菜单关系逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysRoleMenuService")
public class SysRoleMenuServiceImpl extends BaseServiceImpl<SysRoleMenuMapper,SysRoleMenu> implements SysRoleMenuService{
    protected static Logger logger = LoggerFactory.getLogger(SysRoleMenuServiceImpl.class);

    @Autowired
    public SysRoleMenuExtMapper sysRoleMenuExtMapper;

}
