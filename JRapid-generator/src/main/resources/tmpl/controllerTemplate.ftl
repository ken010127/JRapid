package ${basePackage}.web.controller.${modulePackage};

import ${modulePackage}.dto.request.${modulePackage}.${className}Request;
import ${modulePackage}.service.${modulePackage}.${className}Service;
import ${modulePackage}.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* ${comments}
* @author FWJ
* @since ${.now?datetime}
*/
@RestController
@RequestMapping("/${modulePackage}/${className?uncap_first}")
public class ${className}Controller extends BaseController{

    @Autowired
    private ${className}Service ${className?uncap_first}Service;

    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("/platform/${className?uncap_first}");
        return modelAndView;
    }

    @RequestMapping(value = "/getMenuTree",method = RequestMethod.POST)
    public  getMenuTree(){
        return sysMenuService.getMenuTree();
    }

    @RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
    public Object saveSysMenu(@RequestBody SysMenuRequest request) throws Exception {
    return sysMenuService.save(request.getSysMenu());
    }

    @RequestMapping(value = "/deleteMenu", method = RequestMethod.DELETE)
    public Object deleteSysMenu(@RequestBody SysMenuRequest request) throws Exception {
    return sysMenuService.delete(request.getSysMenu().getId());
    }
    }
