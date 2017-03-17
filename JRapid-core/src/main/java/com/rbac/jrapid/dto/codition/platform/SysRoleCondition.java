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
    private String startTime;

    @Condition(queryType = QueryCondition.TIME_LESS_TYPE,queryProperty = "create_time")
    private String endTime;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
