package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 实体类
* Created by JRapid on 2016-9-4 18:17:01.
*/
public class SysMenu implements Serializable {

    public final static String ID = "id";
    public final static String PARENT_ID = "parent_id";
    public final static String MENU_NAME = "menu_name";
    public final static String URL = "url";
    public final static String ICON = "icon";
    public final static String ORDER_NO = "order_no";
    public final static String OPEN_TYPE = "open_type";

    /**
    * 主键
    **/
    @PK
    private Long id;

    /**
    * 父节点ID
    **/
    private Long parentId;

    /**
    * 菜单名称
    **/
    private String menuName;

    /**
    * 菜单访问地址
    **/
    private String url;

    /**
    * 菜单图标
    **/
    private String icon;

    /**
    * 菜单序号
    **/
    private Integer orderNo;

    /**
    * 打开方式
    **/
    private String openType;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getParentId(){
        return parentId;
    }

    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public String getMenuName(){
        return menuName;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public Integer getOrderNo(){
        return orderNo;
    }

    public void setOrderNo(Integer orderNo){
        this.orderNo = orderNo;
    }

    public String getOpenType(){
        return openType;
    }

    public void setOpenType(String openType){
        this.openType = openType;
    }

}