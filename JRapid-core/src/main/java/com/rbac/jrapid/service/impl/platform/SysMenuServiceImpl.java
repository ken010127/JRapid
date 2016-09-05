package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysMenuMapper;
import com.rbac.jrapid.dao.platform.SysMenuExtMapper;
import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.service.platform.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 逻辑处理实现类
* Created by JRapid on 2016-9-4 18:23:09
*/
@Service("SysMenuService")
public class SysMenuServiceImpl implements SysMenuService{
    protected static Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Autowired
    public SysMenuMapper sysMenuMapper;

    @Autowired
    public SysMenuExtMapper sysMenuExtMapper;

    public SysMenu findOne(Long id) throws Exception {
        return sysMenuMapper.findOne(id);
    }

    public int save(SysMenu sysMenu) throws Exception {
        return sysMenuMapper.save(sysMenu);
    }

    public int update(SysMenu sysMenu) throws Exception {
        return sysMenuMapper.update(sysMenu);
    }

    public int updateSelected(SysMenu sysMenu, List<String> list) throws Exception {
        return sysMenuMapper.updateSelected(sysMenu,list);
    }

    public int delete(Long id) throws Exception {
        return sysMenuMapper.delete(id);
    }

    public List<SysMenu> listByCondition(CommonExample commonExample) throws Exception {
        return sysMenuMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysMenuMapper.countByCondition(commonExample);
    }

}
