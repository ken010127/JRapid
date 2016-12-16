package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.converter.TreeConverter;
import com.rbac.jrapid.core.common.dao.CommonExample;
import com.rbac.jrapid.dao.platform.SysMenuMapper;
import com.rbac.jrapid.dao.platform.SysMenuExtMapper;
import com.rbac.jrapid.dto.response.platform.SysMenuResponse;
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

    public SysMenuResponse save(SysMenu sysMenu) throws Exception {
        SysMenuResponse response = new SysMenuResponse();
        int result;
        if (sysMenu.getId()==null){
            result = sysMenuMapper.save(sysMenu);
        }else {
            result = sysMenuMapper.update(sysMenu);
        }

        if (result<0){
            response.setStatus(false);
        }
        response.setSysMenu(sysMenu);
        return response;
    }

    public SysMenuResponse update(SysMenu sysMenu) throws Exception {
        SysMenuResponse response = new SysMenuResponse();
        int result = sysMenuMapper.update(sysMenu);
        if (result<0){
            response.setStatus(false);
        }
        response.setSysMenu(sysMenu);
        return response;
    }

    public SysMenuResponse updateSelected(SysMenu sysMenu, List<String> list) throws Exception {
        SysMenuResponse response = new SysMenuResponse();
        int result = sysMenuMapper.updateSelected(sysMenu,list);
        if (result<0){
            response.setStatus(false);
        }
        response.setSysMenu(sysMenu);
        return response;
    }

    public SysMenuResponse delete(Long id) throws Exception {
        SysMenuResponse response = new SysMenuResponse();
        int result = sysMenuMapper.delete(id);
        if (result<0){
            response.setStatus(false);
        }
        return response;
    }

    public List<SysMenu> listByCondition(CommonExample commonExample) throws Exception {
        return sysMenuMapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return sysMenuMapper.countByCondition(commonExample);
    }

    public List<SysMenu> getMenuTree() {
        TreeConverter<SysMenu> treeConverter = new TreeConverter<>();
        try {
            return treeConverter.converToTreeModel(sysMenuExtMapper.getRoots(),sysMenuMapper.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
