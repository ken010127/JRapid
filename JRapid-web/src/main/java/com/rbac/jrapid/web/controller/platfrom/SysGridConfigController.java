package com.rbac.jrapid.web.controller.platfrom;

import com.rbac.jrapid.dto.request.platform.SysGridConfigRequest;
import com.rbac.jrapid.service.platform.SysGridConfigService;
import com.rbac.jrapid.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* 页面表格配置信息
* @author FWJ
* @since 2016-12-3 18:10:24
*/
@RestController
@RequestMapping("/platform/sysGridConfig")
public class SysGridConfigController extends BaseController{

    @Autowired
    private SysGridConfigService sysGridConfigService;

    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("/platform/sysGridConfig");
        return modelAndView;
    }

}
