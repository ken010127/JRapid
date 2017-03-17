package com.rbac.jrapid.web.controller.platfrom;

import com.rbac.jrapid.core.common.dao.Page;
import com.rbac.jrapid.core.common.dao.QueryCondition;
import com.rbac.jrapid.core.dto.response.BaseResponse;
import com.rbac.jrapid.dto.request.platform.SysRoleRequest;
import com.rbac.jrapid.dto.response.platform.SysRoleResponse;
import com.rbac.jrapid.entity.platform.SysMenu;
import com.rbac.jrapid.entity.platform.SysRole;
import com.rbac.jrapid.service.platform.SysRoleService;
import com.rbac.jrapid.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
* 角色管理
* @author FWJ
* @since 2017-3-14 17:47:06
*/
@RestController
@RequestMapping("/platform/sysRole")
public class SysRoleController extends BaseController{

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView openPage(){
        ModelAndView modelAndView = new ModelAndView("platform/sysRole");
        return modelAndView;
    }

    @RequestMapping(value="/pageQuery", method = RequestMethod.POST)
    public SysRoleResponse pageQuery(@RequestBody SysRoleRequest request){
        SysRoleResponse response = new SysRoleResponse();
        Page<SysRole> page = request.getPage();
        QueryCondition.setPageCondition(page,request.getCondition());
        response.setPage(page);
        return response;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BaseResponse<SysRole> saveSysRole(@RequestBody SysRoleRequest request) throws Exception {
        return sysRoleService.save((SysRole) request.getEntity());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public BaseResponse<SysRole> deleteSysRole(@PathVariable("id") Long id) throws Exception {
        return sysRoleService.delete(id);
    }
}
