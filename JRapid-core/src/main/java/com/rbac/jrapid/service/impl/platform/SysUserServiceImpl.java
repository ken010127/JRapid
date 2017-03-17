package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysUserExtMapper;
import com.rbac.jrapid.dao.platform.SysUserMapper;
import com.rbac.jrapid.entity.platform.SysUser;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 系统用户管理逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper,SysUser> implements SysUserService{
    protected static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    public SysUserExtMapper sysUserExtMapper;

}
