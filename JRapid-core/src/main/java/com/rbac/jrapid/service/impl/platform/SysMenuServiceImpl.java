package com.rbac.jrapid.service.impl.platform;

import com.rbac.jrapid.core.common.converter.TreeConverter;
import com.rbac.jrapid.core.exception.BaseException;
import com.rbac.jrapid.dao.platform.SysMenuExtMapper;
import com.rbac.jrapid.dao.platform.SysMenuMapper;
import com.rbac.jrapid.dto.request.platform.SysMenuRequest;
import com.rbac.jrapid.dto.response.platform.SysMenuResponse;
import com.rbac.jrapid.entity.platform.SysButton;
import com.rbac.jrapid.entity.platform.SysGridConfig;
import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.service.impl.BaseServiceImpl;
import com.rbac.jrapid.service.platform.SysButtonService;
import com.rbac.jrapid.service.platform.SysGridConfigService;
import com.rbac.jrapid.service.platform.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 逻辑处理实现类
* Created by JRapid on 2016-9-4 18:23:09
*/
@Transactional
@Service("SysMenuService")
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper,SysMenu> implements SysMenuService{
    protected static Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Autowired
    public SysMenuExtMapper sysMenuExtMapper;

    @Autowired
    public SysButtonService sysButtonService;

    @Autowired
    public SysGridConfigService sysGridConfigService;

    public SysMenuResponse delete(Long id) throws Exception {
        SysMenuResponse response = delete(id);
        if (sysButtonService.deleteByMenuId(id)<0){
            throw new BaseException("","删除按钮失败！");
        }
        if(sysGridConfigService.deleteByMenuId(id)<0){
            throw new BaseException("","删除表格配置失败！");
        }
        return response;
    }

    public List<SysMenu> getMenuTree() {
        TreeConverter<SysMenu> treeConverter = new TreeConverter<>();
        try {
            List<SysMenu> sysMenus = treeConverter.converToTreeModel(sysMenuExtMapper.getRoots(),findAll());
            return sysMenus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SysMenuResponse saveMenuConfig(SysMenuRequest request) throws Exception{
        SysMenuResponse response = new SysMenuResponse();
        SysMenu sysMenu = request.getSysMenu();
        StringBuffer buttonError = new StringBuffer();
        StringBuffer gridConfigError = new StringBuffer();
        //保存菜单信息
        if (sysMenu.getId()==null){
            save(sysMenu);
        }else {
            update(sysMenu);
        }

        //保存按钮信息
        List<SysButton> sysButtons = request.getSysButtons();
        for (SysButton button : sysButtons){
            button.setMenuId(sysMenu.getId());
            if (!sysButtonService.saveOrUpdate(button).getStatus()){
                buttonError.append(button.getButtonName()).append("保存失败！/n");
            }
        }

        //保存表格配置信息
        List<SysGridConfig> sysGridConfigs = request.getSysGridConfigs();
        for (SysGridConfig gridConfig : sysGridConfigs){
            gridConfig.setMenuId(sysMenu.getId());
            if (!sysGridConfigService.saveOrUpdate(gridConfig).getStatus()){
                gridConfigError.append(gridConfig.getDictionary()).append("保存失败！/n");
            }
        }

        if (buttonError.length()>0 || gridConfigError.length()>0){
            response.setStatus(false);
            response.setErrorMsg(buttonError.toString()+"/n"+gridConfigError.toString());
        }

        return response;
    }

    @Override
    public SysMenuResponse getMenuConfigInfo(Long menuId) throws Exception {
        SysMenuResponse response = new SysMenuResponse();
        SysMenu sysMenu = findOne(menuId);
        List<SysButton> sysButtons = sysButtonService.queryButtonByMenuId(menuId);
        List<SysGridConfig> sysGridConfigs = sysGridConfigService.queryGridConfigByMenuId(menuId);

        response.setEntity(sysMenu);
        response.setSysButtons(sysButtons);
        response.setSysGridConfigs(sysGridConfigs);

        return response;
    }

}
