package com.rbac.jrapid.core.common.dao;

import com.rbac.jrapid.core.common.annotation.Condition;
import com.rbac.jrapid.core.common.reader.DBPropertiesReader;
import com.rbac.jrapid.core.common.utils.ObjectUtils;
import com.rbac.jrapid.core.common.utils.ReflectionUtils;
import com.rbac.jrapid.core.common.utils.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询条件
 * @author FWJ
 * @since 2016/11/15 上午10:47
 */
public class QueryCondition implements Serializable{

    private static final long serialVersionUID = -639963874811754837L;

    public static final String LIKE_TYPE = "LIKE";
    public static final String Left_LIKE_TYPE = "LEFT_LIKE";
    public static final String RIGHT_LIKE_TYPE = "RIGHT_LIKE";
    public static final String EQUAL_TYPE = "EQUAL";
    public static final String IN_TYPE = "IN";
    public static final String EXIST_TYPE = "EXIST";
    public static final String GREATER_TYPE = "GREATER";
    public static final String LESS_TYPE = "LESS";
    public static final String TIME_GREATER_TYPE = "TIME_GREATER";
    public static final String TIME_LESS_TYPE = "TIME_LESS";

    public static List<String> convertSql(Object object){
        List<String> conditionSql = new ArrayList<>();

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Condition.class)) {
                Condition condition = field.getAnnotation(Condition.class);
                conditionSql.add(combinSql(condition,field));
            }
        }
        return conditionSql;
    }

    /**
     * 设置分页查询条件
     * @param page 分页javabean
     * @param object 查询条件javabean
     */
    public static void setPageCondition(Page page,Object object){
        if(object!=null){
            List<String> conditionSql = new ArrayList<>();
            Map<String, Object> params = new HashMap<>();

            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Condition.class)) {
                    Object value = ReflectionUtils.invokeGetterMethod(object,field.getName());
                    if (ObjectUtils.isEmpty(value)){
                        Condition condition = field.getAnnotation(Condition.class);
                        conditionSql.add(combinSql(condition,field));
                        params.put(field.getName(),value);
                    }
                }
            }
            page.setCondition(conditionSql);
            page.setParams(params);
        }
    }

    /**
     * 获取拼接字符串
     * @param condition 条件注解
     * @param field 属性
     * @return sql
     */
    private static String combinSql(Condition condition, Field field){

        StringBuffer sb = new StringBuffer();

        if(LIKE_TYPE.equals(condition.queryType())){
            sb.append(condition.queryProperty()).append(" like concat('%',#{page.params.")
                    .append(field.getName()).append("},'%') ");
        }
        if(Left_LIKE_TYPE.equals(condition.queryType())){
            sb.append(condition.queryProperty()).append(" like concat('%',#{page.params.")
                    .append(field.getName()).append("}) ");
        }
        if(RIGHT_LIKE_TYPE.equals(condition.queryType())){
            sb.append(condition.queryProperty()).append(" like concat('%',#{page.params.")
                    .append(field.getName()).append("},'%') ");
        }
        if(EQUAL_TYPE.equals(condition.queryType())){
            sb.append(condition.queryProperty()).append(" = #{page.params.")
                    .append(field.getName()).append("} ");
        }
        if(IN_TYPE.equals(condition.queryType())){
            //TODO in查询
        }
        if(EXIST_TYPE.equals(condition.queryType()) && StringUtils.isEmpty(condition.existSql())){
            sb.append(" exist (").append(condition.existSql()).append(") ");
        }
        if(GREATER_TYPE.equals(condition.queryType())){
            sb.append(" <![CDATA[").append(condition.queryProperty()).append(" < #{page.params.")
                    .append(field.getName()).append("} ]] ");
        }
        if(LESS_TYPE.equals(condition.queryType())){
            sb.append(" <![CDATA[").append(condition.queryProperty()).append(" > #{page.params.")
                    .append(field.getName()).append("} ]] ");
        }
        if(TIME_GREATER_TYPE.equals(condition.queryType())){
            sb.append(" <![CDATA[").append(getTimeFormatMethodStr()).append("(#{page.params.").append(field.getName()).
                    append("},").append(getTimeFormatStr()).append(")>").append(condition.queryProperty()).append("}]] ");
        }
        if(TIME_LESS_TYPE.equals(condition.queryType())){
            sb.append("<![CDATA[").append(getTimeFormatMethodStr()).append("(#{page.params.").append(field.getName()).
                    append("},").append(getTimeFormatStr()).append(")<").append(condition.queryProperty()).append("}]] ");
        }

        return sb.toString();
    }

    /**
     * 获取数据时间装换函数字符
     * @return 函数名称
     */
    private static String getTimeFormatMethodStr(){
        if("mysql".equals(DBPropertiesReader.getValue("db.dbType"))){
            return "DATE_FORMAT";
        }else if ("oracle".equals(DBPropertiesReader.getValue("db.dbType"))){
            return "TO_DATE";
        }
        return null;
    }

    /**
     * 获取时间格式化字符串
     * @return 格式化规范
     */
    private static String getTimeFormatStr(){
        if("mysql".equals(DBPropertiesReader.getValue("db.dbType"))){
            return "'%Y-%m-%d %H:%i:%s'";
        }else if ("oracle".equals(DBPropertiesReader.getValue("db.dbType"))){
            return "'yyyy-mm-dd hh24:mi:ss'";
        }
        return null;
    }
}
