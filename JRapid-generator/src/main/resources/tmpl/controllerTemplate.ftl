package ${basePackage}.web.controller.${modulePackage};

import ${basePackage}.core.common.dao.Page;
import ${basePackage}.dto.request.${modulePackage}.${className}Request;
import ${basePackage}.service.${modulePackage}.${className}Service;
import ${basePackage}.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("${modulePackage}/${className?uncap_first}");
        return modelAndView;
    }

    @RequestMapping(value="/pageQuery", method = RequestMethod.POST)
    public Page<${className}> pageQuery(@RequestBody ${className}Request request){
        return ${className?uncap_first}Service.pageQuery(request.getPage());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BaseResponse<${className}> save${className}(@RequestBody ${className}Request request) throws Exception {
        return ${className?uncap_first}Service.save((${className}) request.getEntity());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public BaseResponse<${className}> delete${className}(@PathVariable("id") Long id) throws Exception {
        return ${className?uncap_first}Service.delete(id);
    }
}
