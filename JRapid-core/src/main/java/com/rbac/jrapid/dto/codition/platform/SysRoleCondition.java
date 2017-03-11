package com.rbac.jrapid.dto.codition.platform;

import com.rbac.jrapid.core.common.annotation.Condition;
import com.rbac.jrapid.core.common.dao.QueryCondition;

import java.util.Date;

/**
 * 角色查询条件
 * @author FWJ
 * @since 2017/3/11 下午5:10
 */
public class SysRoleCondition {

    @Condition(queryProperty = "role_name")
    private String roleName;

    @Condition(queryType = QueryCondition.TIME_GREATER_TYPE,queryProperty = "create_time")
    private Date startTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
