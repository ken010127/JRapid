package ${basePackage}.web.controller.${modulePackage};

import ${basePackage}.dto.request.${modulePackage}.${className}Request;
import ${basePackage}.service.${modulePackage}.${className}Service;
import ${basePackage}.web.controller.BaseController;
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
        ModelAndView modelAndView = new ModelAndView("/content/platform/${className?uncap_first}");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Object save${className}(@RequestBody ${className}Request request) throws Exception {
        return ${className?uncap_first}Service.save(request.get${className}());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Object delete${className}(@PathVariable("id") Long id) throws Exception {
        return ${className?uncap_first}Service.delete(id);
    }
}
