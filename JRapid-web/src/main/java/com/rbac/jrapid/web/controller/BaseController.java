package com.rbac.jrapid.web.controller;

import com.rbac.jrapid.core.dto.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * controller基础类
 * @author FWJ
 * @since 2016/11/14 下午4:50
 */
public class BaseController {

    protected static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /*拦截这个controller任何一个方法的异常*/
    @ExceptionHandler({Exception.class })
    public BaseResponse handleBaseException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(false);
        baseResponse.setErrorMsg(ex.getMessage());
        return baseResponse;
    }

    //TODO 添加获取当前用户，当前部门的方法

    /*public BaseResponse Success(Object response){

    }*/
}
