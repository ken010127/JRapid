package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysOrgExtMapper;
import com.rbac.jrapid.dao.platform.SysOrgMapper;
import com.rbac.jrapid.entity.platform.SysOrg;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 组织架构逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysOrgService")
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgMapper,SysOrg> implements SysOrgService{
    protected static Logger logger = LoggerFactory.getLogger(SysOrgServiceImpl.class);

    @Autowired
    public SysOrgExtMapper sysOrgExtMapper;

}
