package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysTreeResourceExtMapper;
import com.rbac.jrapid.dao.platform.SysTreeResourceMapper;
import com.rbac.jrapid.entity.platform.SysTreeResource;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysTreeResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 树资源信息，管理树机构的表信息逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysTreeResourceService")
public class SysTreeResourceServiceImpl extends BaseServiceImpl<SysTreeResourceMapper,SysTreeResource> implements SysTreeResourceService{
    protected static Logger logger = LoggerFactory.getLogger(SysTreeResourceServiceImpl.class);

    @Autowired
    public SysTreeResourceExtMapper sysTreeResourceExtMapper;

}
