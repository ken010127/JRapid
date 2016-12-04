package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysRoleButtonExtMapper;
import com.rbac.jrapid.dao.platform.SysRoleButtonMapper;
import com.rbac.jrapid.entity.platform.SysRoleButton;
import com.rbac.jrapid.service.platform.SysRoleButtonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysRoleButtonService")
public class SysRoleButtonServiceImpl implements SysRoleButtonService{
    protected static Logger logger = LoggerFactory.getLogger(SysRoleButtonServiceImpl.class);

    @Autowired
    public SysRoleButtonMapper sysRoleButtonMapper;

    @Autowired
    public SysRoleButtonExtMapper sysRoleButtonExtMapper;

    public SysRoleButton findOne(Long id) throws Exception {
        return sysRoleButtonMapper.findOne(id);
    }

    public Integer save(SysRoleButton sysRoleButton) throws Exception {
        return sysRoleButtonMapper.save(sysRoleButton);
    }

    public Integer update(SysRoleButton sysRoleButton) throws Exception {
        return sysRoleButtonMapper.update(sysRoleButton);
    }

    public Integer updateSelected(SysRoleButton sysRoleButton, List<String> list) throws Exception {
        return sysRoleButtonMapper.updateSelected(sysRoleButton,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysRoleButtonMapper.delete(id);
    }

    public List<SysRoleButton> listByCondition(CommonExample commonExample) throws Exception {
        return sysRoleButtonMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysRoleButtonMapper.countByCondition(commonExample);
    }

}
