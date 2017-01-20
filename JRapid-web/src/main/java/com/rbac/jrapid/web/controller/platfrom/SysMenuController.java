package com.rbac.jrapid.web.controller.platfrom;

import com.rbac.jrapid.dto.request.platform.SysMenuRequest;
import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.service.platform.SysIconService;
import com.rbac.jrapid.service.platform.SysMenuService;
import com.rbac.jrapid.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 菜单
 * @author FWJ
 * @since 2016/11/14 上午10:51
 */
@RestController
@RequestMapping("/platform/sysMenu")
public class SysMenuController extends BaseController{

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysIconService sysIconService;

    @RequestMapping(value = "/openPage", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("platform/sysMenu");
        return modelAndView;
    }

    @RequestMapping(value = "/getMenuTree",method = RequestMethod.POST)
    public List<SysMenu> getMenuTree(){
        return sysMenuService.getMenuTree();
    }

    @RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
    public Object saveSysMenu(@RequestBody SysMenuRequest request) throws Exception {
        return sysMenuService.saveMenuConfig(request);
    }

    @RequestMapping(value = "/deleteMenu/{id}", method = RequestMethod.DELETE)
    public Object deleteSysMenu(@PathVariable("id") Long menuId) throws Exception {
        return sysMenuService.delete(menuId);
    }

    @RequestMapping(value = "/getMenuConfigInfo/{id}", method = RequestMethod.GET)
    public Object getMenuConfigInfo(@PathVariable("id") Long menuId) throws Exception{
        return sysMenuService.getMenuConfigInfo(menuId);
    }

    @RequestMapping(value = "/getIconNames/{type}", method = RequestMethod.GET)
    public List<String> getIconNames(@PathVariable("type") String type) throws Exception{
        return sysIconService.getIcons(type);
    }
}
