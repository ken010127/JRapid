package com.rbac.jrapid.web.controller.platfrom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单
 * @author FWJ
 * @since 2016/11/14 上午10:51
 */
@RestController
@RequestMapping("/platform/sysMenu")
public class SysMenuController {

    @RequestMapping(value = "/openPage", method = RequestMethod.GET)
    public String openPage(){
        return "/platform/sysMenu";
    }




}
