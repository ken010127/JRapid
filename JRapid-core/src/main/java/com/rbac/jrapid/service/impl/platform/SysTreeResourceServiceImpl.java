package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysTreeResourceExtMapper;
import com.rbac.jrapid.dao.platform.SysTreeResourceMapper;
import com.rbac.jrapid.entity.platform.SysTreeResource;
import com.rbac.jrapid.service.platform.SysTreeResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 树资源信息，管理树机构的表信息逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysTreeResourceService")
public class SysTreeResourceServiceImpl implements SysTreeResourceService{
    protected static Logger logger = LoggerFactory.getLogger(SysTreeResourceServiceImpl.class);

    @Autowired
    public SysTreeResourceMapper sysTreeResourceMapper;

    @Autowired
    public SysTreeResourceExtMapper sysTreeResourceExtMapper;

    public SysTreeResource findOne(Long id) throws Exception {
        return sysTreeResourceMapper.findOne(id);
    }

    public Integer save(SysTreeResource sysTreeResource) throws Exception {
        return sysTreeResourceMapper.save(sysTreeResource);
    }

    public Integer update(SysTreeResource sysTreeResource) throws Exception {
        return sysTreeResourceMapper.update(sysTreeResource);
    }

    public Integer updateSelected(SysTreeResource sysTreeResource, List<String> list) throws Exception {
        return sysTreeResourceMapper.updateSelected(sysTreeResource,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysTreeResourceMapper.delete(id);
    }

    public List<SysTreeResource> listByCondition(CommonExample commonExample) throws Exception {
        return sysTreeResourceMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysTreeResourceMapper.countByCondition(commonExample);
    }

}
