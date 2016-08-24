package com.rbac.jrapid.core.db.mybatis.interceptor;

import com.rbac.jrapid.core.common.dao.IdWorker;
import com.rbac.jrapid.core.db.mybatis.annotation.AnnotationParser;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 新增时自动插入主键
 * @author FWJ
 * @Created on 2016/8/23  20:01
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class IdentityInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        if ( mappedStatement.getSqlCommandType() != SqlCommandType.INSERT ) {
            return invocation.proceed();
        }
        Object param = invocation.getArgs()[1];
        AnnotationParser.setPKvalue(param, IdWorker.getId());
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    public void setProperties(Properties properties) {

    }
}
