package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 按钮管理实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysButton implements Serializable {

    public final static String ID = "id";
    public final static String BUTTON_NAME = "button_name";
    public final static String ICON = "icon";
    public final static String EVENT = "event";
    public final static String WIDGET_ID = "widget_id";
    public final static String DESCRIPTION = "description";
    public final static String ORDER_NO = "order_no";
    public final static String MENU_ID = "menu_id";

    /**
    * 主键ID
    **/
    @PK
    private Long id;

    /**
    * 按钮名称
    **/
    private String buttonName;

    /**
    * 按钮图标
    **/
    private String icon;

    /**
    * 按钮触发事件
    **/
    private String event;

    /**
    * 按钮html ID
    **/
    private String widgetId;

    /**
    * 描述
    **/
    private String description;

    /**
    * 序号
    **/
    private Integer orderNo;

    /**
    * 菜单ID
    **/
    private Long menuId;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getButtonName(){
        return buttonName;
    }

    public void setButtonName(String buttonName){
        this.buttonName = buttonName;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getEvent(){
        return event;
    }

    public void setEvent(String event){
        this.event = event;
    }

    public String getWidgetId(){
        return widgetId;
    }

    public void setWidgetId(String widgetId){
        this.widgetId = widgetId;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Integer getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }

    public Long getMenuId(){
        return menuId;
    }

    public void setMenuId(Long menuId){
        this.menuId = menuId;
    }

}