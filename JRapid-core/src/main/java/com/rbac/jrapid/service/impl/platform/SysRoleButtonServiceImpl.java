package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.dao.platform.SysRoleButtonExtMapper;
import com.rbac.jrapid.dao.platform.SysRoleButtonMapper;
import com.rbac.jrapid.entity.platform.SysRoleButton;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysRoleButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* 逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysRoleButtonService")
public class SysRoleButtonServiceImpl extends BaseServiceImpl<SysRoleButtonMapper,SysRoleButton> implements SysRoleButtonService{
    protected static Logger logger = LoggerFactory.getLogger(SysRoleButtonServiceImpl.class);

    @Autowired
    public SysRoleButtonExtMapper sysRoleButtonExtMapper;

}
