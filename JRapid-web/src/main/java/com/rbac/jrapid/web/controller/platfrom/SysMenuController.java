package com.rbac.jrapid.web.controller.platfrom;

import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.service.platform.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 菜单
 * @author FWJ
 * @since 2016/11/14 上午10:51
 */
@RestController
@RequestMapping("/platform/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/openPage", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("/platform/sysMenu");
        return modelAndView;
    }

    @RequestMapping(value = "/getMenuTree",method = RequestMethod.POST)
    public List<SysMenu> getMenuTree(){
        return sysMenuService.getMenuTree();
    }

}
