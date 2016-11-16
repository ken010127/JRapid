package com.rbac.jrapid.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller基础类
 * @author FWJ
 * @since 2016/11/14 下午4:50
 */
public class BaseController {

    protected static Logger logger = LoggerFactory.getLogger(BaseController.class);

    /*拦截这个controller任何一个方法的异常
    @ExceptionHandler({ BaseException.class, Exception.class })
    public ModelAndView handleBaseException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

    }*/

    //TODO 添加获取当前用户，当前部门的方法
}
