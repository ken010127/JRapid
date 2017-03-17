package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysRoleExtMapper;
import com.rbac.jrapid.dao.platform.SysRoleMapper;
import com.rbac.jrapid.entity.platform.SysRole;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 角色管理逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper,SysRole> implements SysRoleService{
    protected static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Autowired
    public SysRoleExtMapper sysRoleExtMapper;

}
