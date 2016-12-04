package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysRoleMenuExtMapper;
import com.rbac.jrapid.dao.platform.SysRoleMenuMapper;
import com.rbac.jrapid.entity.platform.SysRoleMenu;
import com.rbac.jrapid.service.platform.SysRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 角色菜单关系逻辑处理实现类
* Created by JRapid on 2016-11-30 16:29:53
*/
@Service("SysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService{
    protected static Logger logger = LoggerFactory.getLogger(SysRoleMenuServiceImpl.class);

    @Autowired
    public SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    public SysRoleMenuExtMapper sysRoleMenuExtMapper;

    public SysRoleMenu findOne(Long id) throws Exception {
        return sysRoleMenuMapper.findOne(id);
    }

    public Integer save(SysRoleMenu sysRoleMenu) throws Exception {
        return sysRoleMenuMapper.save(sysRoleMenu);
    }

    public Integer update(SysRoleMenu sysRoleMenu) throws Exception {
        return sysRoleMenuMapper.update(sysRoleMenu);
    }

    public Integer updateSelected(SysRoleMenu sysRoleMenu, List<String> list) throws Exception {
        return sysRoleMenuMapper.updateSelected(sysRoleMenu,list);
    }

    public Integer delete(Long id) throws Exception {
        return sysRoleMenuMapper.delete(id);
    }

    public List<SysRoleMenu> listByCondition(CommonExample commonExample) throws Exception {
        return sysRoleMenuMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysRoleMenuMapper.countByCondition(commonExample);
    }

}
