package com.rbac.jrapid.web.controller.platfrom;

import com.rbac.jrapid.core.dto.vo.EasyUITreeNodeVO;
import com.rbac.jrapid.dto.request.platform.SysDictionaryRequest;
import com.rbac.jrapid.entity.platform.SysDictionary;
import com.rbac.jrapid.service.platform.SysDictionaryService;
import com.rbac.jrapid.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* 数据字典
* @author FWJ
* @author FWJ
* @author FWJ
* @since 2016-12-12 14:03:32
*/
@RestController
@RequestMapping("/platform/sysDictionary")
public class SysDictionaryController extends BaseController{

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("/platform/sysDictionary");
        return modelAndView;
    }

    @RequestMapping(value = "/saveSysDictionary", method = RequestMethod.POST)
    public Object saveSysDictionary(@RequestBody SysDictionaryRequest request) throws Exception {
        return sysDictionaryService.save(request.getSysDictionary());
    }

    @RequestMapping(value = "/deleteSysDictionary", method = RequestMethod.DELETE)
    public Object deleteSysDictionary(@RequestBody SysDictionaryRequest request) throws Exception {
        return sysDictionaryService.delete(request.getSysDictionary().getId());
    }

    @RequestMapping(value = "/queryChildrenByCode/{parentCode}", method = RequestMethod.GET)
    public List<SysDictionary> queryChildrenByCode(@PathVariable String parentCode){
        return sysDictionaryService.queryChildrenByCode(parentCode);
    }

    @RequestMapping(value = "/queryEasyuiTreeChildren",method = RequestMethod.POST)
    public List<EasyUITreeNodeVO> queryEasyuiTreeChildren(@RequestParam(value = "nodeId",required = false) String nodeId){
        return sysDictionaryService.queryEasyuiTreeChildren(nodeId);
    }
}
