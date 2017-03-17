package com.rbac.jrapid.core.common.dao;

import com.rbac.jrapid.core.common.utils.DateUtil;
import com.rbac.jrapid.dto.codition.platform.SysRoleCondition;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author FWJ
 * @since 2017/3/13 上午9:23
 */
public class QueryConditionTest {
    @Test
    public void combinSql() throws Exception {
        SysRoleCondition condition = new SysRoleCondition();
        condition.setRoleName("admin");
        condition.setStartTime(DateUtil.dateToStr(new Date()));

        List<String> sqls = QueryCondition.convertSql(condition);

        for (String sql : sqls)
            System.out.println(sql);
    }

}