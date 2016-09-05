package com.rbac.jrapid.web.controller.platfrom;

import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.service.platform.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FWJ
 * Created on 2016/8/29 15:03
 */
@Controller
@RequestMapping("/test")
public class TestController {
    protected static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    public SysMenuService sysMenuService;

    @RequestMapping("/test")
    public String testPage(Model model){
        model.addAttribute("user","test");
        model.addAttribute("password","password");
        return "test";
    }

    @RequestMapping("/save")
    public String save(){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(0L);
        sysMenu.setMenuName("基础设置");
        sysMenu.setIcon("fa-dashboard");
        try {
            sysMenuService.save(sysMenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "test";
    }
}
