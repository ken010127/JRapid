package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysUserOrgExtMapper;
import com.rbac.jrapid.dao.platform.SysUserOrgMapper;
import com.rbac.jrapid.entity.platform.SysUserOrg;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysUserOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 用户组织机构关系逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysUserOrgService")
public class SysUserOrgServiceImpl extends BaseServiceImpl<SysUserOrgMapper,SysUserOrg> implements SysUserOrgService{
    protected static Logger logger = LoggerFactory.getLogger(SysUserOrgServiceImpl.class);

    @Autowired
    public SysUserOrgExtMapper sysUserOrgExtMapper;

}
