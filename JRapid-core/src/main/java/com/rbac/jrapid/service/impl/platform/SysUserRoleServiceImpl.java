package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysUserRoleExtMapper;
import com.rbac.jrapid.dao.platform.SysUserRoleMapper;
import com.rbac.jrapid.entity.platform.SysUserRole;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 用户角色关系逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleMapper,SysUserRole> implements SysUserRoleService{
    protected static Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    @Autowired
    public SysUserRoleExtMapper sysUserRoleExtMapper;

}
