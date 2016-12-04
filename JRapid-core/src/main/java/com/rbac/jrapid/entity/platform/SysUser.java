package com.rbac.jrapid.entity.platform;

import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* 系统用户管理实体类
* Created by JRapid on 2016-11-30 16:29:53.
*/
public class SysUser implements Serializable {

    public final static String ID = "id";
    public final static String ACCOUNT = "account";
    public final static String LOGIN_PWD = "login_pwd";
    public final static String USER_NAME = "user_name";
    public final static String ENABLED = "enabled";
    public final static String CREATE_USER = "create_user";
    public final static String CREATE_TIME = "create_time";
    public final static String MODIFY_USER = "modify_user";
    public final static String MODIFY_TIME = "modify_time";

    /**
    * 主键ID
    **/
    @PK
    private Long id;

    /**
    * 用户账号
    **/
    private String account;

    /**
    * 密码
    **/
    private String loginPwd;

    /**
    * 用户名
    **/
    private String userName;

    /**
    * 是否可用
    **/
    private Byte enabled;

    /**
    * 创建人
    **/
    private String createUser;

    /**
    * 创建时间
    **/
    private java.util.Date createTime;

    /**
    * 修改人
    **/
    private String modifyUser;

    /**
    * 修改时间
    **/
    private java.util.Date modifyTime;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public String getLoginPwd(){
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd){
        this.loginPwd = loginPwd;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public Byte getEnabled(){
        return enabled;
    }

    public void setEnabled(Byte enabled){
        this.enabled = enabled;
    }

    public String getCreateUser(){
        return createUser;
    }

    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }

    public java.util.Date getCreateTime(){
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }

    public String getModifyUser(){
        return modifyUser;
    }

    public void setModifyUser(String modifyUser){
        this.modifyUser = modifyUser;
    }

    public java.util.Date getModifyTime(){
        return modifyTime;
    }

    public void setModifyTime(java.util.Date modifyTime){
        this.modifyTime = modifyTime;
    }

}