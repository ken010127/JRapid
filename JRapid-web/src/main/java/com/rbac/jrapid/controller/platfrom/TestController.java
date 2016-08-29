package com.rbac.jrapid.controller.platfrom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author FWJ
 * Created on 2016/8/29 15:03
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String testPage(Model model){
        model.addAttribute("user","test");
        model.addAttribute("password","password");
        return "test";
    }

}
