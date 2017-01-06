package com.rbac.jrapid.core.common.dao;

import com.rbac.jrapid.core.common.utils.DateUtil;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;



public class PresetCriteria extends CommonExample.Criteria implements Serializable{

    private static final long serialVersionUID = -2871812979417212307L;

    protected CommonExample example;

    public PresetCriteria(CommonExample example){
        this.example=example;
    }

    //测试的时候需要测试value中含有%，_之类的场景
    @Override
    public CommonExample.Criteria like(String andor, String columnName, int type, Object value) {
        String sql=getLikeSQL(andor, columnName, type, value);
        if(sql!=null){
            addCriterion(sql);
        }
        return this;


    };

    public String getLikeSQL(String andor, String columnName, int type, Object value){

        if (valueIsempty(value)) {
            return null;
        }
        String sql=null;
        boolean isContains = false;
        if (value.toString().contains("%")) {
            value = value.toString().replaceAll("%", "/%");
            isContains = true;
        }
        if (value.toString().contains("_")) {
            value = value.toString().replaceAll("_", "/_");
            isContains = true;
        }
        value="%"+value.toString().trim().replace("'","''")+"%";
        String placeHolder=this.getPlaceHolder(type,value);
        if(placeHolder==null){
            return sql;
        }
        //为什么要替换？待会儿再看
        //String类型的变量不要分开累加
        if (isContains) {
            sql = " "+andor+" "+columnName+" like "+placeHolder + " " + "escape '/'";
        }else{
            sql=" "+andor+" "+columnName+" like "+placeHolder+" ";
        }
        return sql;

    }
    @Override
    public CommonExample.Criteria likes(String andor, String columnName, int type, Object value) {
        if(valueIsempty(value)){
            return this;
        }
        StringBuilder builder=new StringBuilder();
        builder.append(" ").append(andor).append("(");
        boolean firstFlag=true;
        for (String str:value.toString().split(",")) {
            if (firstFlag) {
                firstFlag=false;
            } else {
                builder.append(" ").append(CommonExample.OR).append(" ");
            }
            String sql=this.getLikeSQL("", columnName, type, str);
            if(sql!=null){
                builder.append(sql);

            }

        }
        builder.append(" )");
        addCriterion(builder.toString());
        return this;
    }

    @Override
    public CommonExample.Criteria in(String andor, String colunnName, int type, Object value) {


        if(valueIsempty(value)){
            return (CommonExample.Criteria)this;
        }

        StringBuilder sb=new StringBuilder();
        sb.append(" ").append(andor).append(" ").append(colunnName).append(" in (");
        if (value instanceof Collection) {
            Collection<Object> collection=(Collection<Object>) value;
            Iterator<Object> iterator=collection.iterator();
            boolean isFirst=true;
            while(iterator.hasNext()){
                Object obj=iterator.next();
                String placeHolder=this.getPlaceHolder(type, obj);
                if(isFirst){
                    sb.append(" ").append(placeHolder);
                    isFirst=false;
                }else
                    sb.append(" ,").append(placeHolder);


            }
        } else if(value.getClass().isArray()){
            Object[] array=(Object[]) value;
            boolean isFirst=true;
            for(Object obj:array){
                String placeHolder=this.getPlaceHolder(type, obj);
                if(isFirst){
                    sb.append(" ").append(placeHolder);
                    isFirst=false;
                }else
                    sb.append(" ,").append(placeHolder);
            }
        }else {
            String[] arr=value.toString().trim().split(",");
            boolean isFirst=true;
            for(String s:arr){
                String placeHolder=this.getPlaceHolder(type, s);
                if(isFirst){
                    sb.append(" ").append(placeHolder);
                    isFirst=false;
                }else
                    sb.append(" ,").append(placeHolder);
            }

        }
        sb.append(")");

        addCriterion(sb.toString());
        return (CommonExample.Criteria)this;

    }

    @Override
    public CommonExample.Criteria between(String andor, String columnName, int type, Object value1, Object value2) {
        String sql="";
        if (value1==null || value2==null) {
            return (CommonExample.Criteria)this;
        }
        String str1=getPlaceHolder(type,value1);
        String str2=getPlaceHolder(type,value2);
        if (str1==null||str2==null) {
            return (CommonExample.Criteria)this;
        }
        sql=" "+andor+" "+columnName+" between("+str1+" and "+str2+") ";

        addCriterion(sql);
        return (CommonExample.Criteria)this;
    }

    @Override
    public CommonExample.Criteria datebetween(String andor, String columnName, Object begindate, Object enddate) {

        String sql=null;
        if (begindate==null && enddate==null) {
            return (CommonExample.Criteria)this;
        }
        if (!valueIsempty(begindate) && valueIsempty(enddate)) {
            String placeHolder=this.getPlaceHolder(CommonExample.D, begindate);
            sql=" "+andor+" "+columnName+">= to_date("+placeHolder+",'yyyy-mm-dd hh24:mi:ss') ";
        } else if (valueIsempty(begindate) && !valueIsempty(enddate)) {
            String placeHolder=this.getPlaceHolder(CommonExample.D, enddate);
            sql=" "+andor+" "+columnName+"<= to_date("+placeHolder+",'yyyy-mm-dd hh24:mi:ss') ";
        } else if (!valueIsempty(begindate) && !valueIsempty(enddate)) {
            String placeHolder1=this.getPlaceHolder(CommonExample.D, begindate);
            String placeHolder2=this.getPlaceHolder(CommonExample.D, enddate);
            sql=" "+andor+" "+columnName+" >= to_date("+placeHolder1+",'yyyy-mm-dd hh24:mi:ss') and "+columnName+" <= to_date("+placeHolder2+",'yyyy-mm-dd hh24:mi:ss') ";
        }
        if(sql!=null){
            addCriterion(sql);
        }
        return (CommonExample.Criteria)this;

    }

    @Override
    public CommonExample.Criteria datebetween(String andor, String columnName, Object begindate, Object enddate, String begin_timeFormat, String end_timeFormat) {

        String sql=null;
        if (begindate==null && enddate==null) {
            return (CommonExample.Criteria)this;
        }

        if (!valueIsempty(begindate) && valueIsempty(enddate)) {
            String placeHolder=this.getPlaceHolder(CommonExample.D, begindate,begin_timeFormat);
            sql=" "+andor+" "+columnName+">= to_date("+placeHolder+",'yyyy-mm-dd hh24:mi:ss') ";
        } else if (valueIsempty(begindate) && !valueIsempty(enddate)) {
            String placeHolder=this.getPlaceHolder(CommonExample.D, enddate,end_timeFormat);
            sql=" "+andor+" "+columnName+"<= to_date("+placeHolder+",'yyyy-mm-dd hh24:mi:ss') ";
        } else if (!valueIsempty(begindate) && !valueIsempty(enddate)) {
            String placeHolder1=this.getPlaceHolder(CommonExample.D, begindate,begin_timeFormat);
            String placeHolder2=this.getPlaceHolder(CommonExample.D, enddate,end_timeFormat);
            sql=" "+andor+" "+columnName+" >= to_date("+placeHolder1+",'yyyy-mm-dd hh24:mi:ss') and "+columnName+" <= to_date("+placeHolder2+",'yyyy-mm-dd hh24:mi:ss') ";
        }
        if(sql!=null){
            addCriterion(sql);
        }
        return (CommonExample.Criteria)this;

    }
    private boolean valueIsempty(Object value) {
        return value==null || "".equals(value);
    }
    @Override
    public CommonExample.Criteria common(String operate, String andor, String columnName, int type, Object value) {

        String sql=null;
        if (valueIsempty(value)) {
            return (CommonExample.Criteria)this;
        }
        if (value instanceof String&&((String) value).length()<1) {
            return (CommonExample.Criteria)this;
        }
        if(type==CommonExample.D){
            sql=" "+andor+" "+columnName+operate+" to_date("+getPlaceHolder(type,value)+",'yyyy-mm-dd hh24:mi:ss') ";
        }else{
            sql=" "+andor+" "+columnName+operate+getPlaceHolder(type,value)+" ";
        }
        if(sql!=null){
            addCriterion(sql);
        }
        return (CommonExample.Criteria)this;

    }
    private String transferTime(Object obj,String attachment) {
        String date_str=null;
        if ((obj instanceof String)&&(obj.toString().trim().length()>0)) {
            if (CommonExample.datepattern.matcher(obj.toString()).matches()) {
                if(this.valueIsempty(attachment)){
                    date_str=obj+" 00:00:00";
                }else{
                    date_str=obj+" "+attachment;
                }
            } else if (CommonExample.datetimepattern.matcher(obj.toString()).matches()) {
                date_str=obj.toString();
            } else {
                boolean flag=true;
                for (char c:((String) obj).toCharArray()) {
                    if (c>='0'&&c<='9') {
                        continue;
                    } else {
                        flag=false;
                        break;
                    }
                }
                if (flag) {
                    date_str=DateUtil.dateToStr(new Date(Long.parseLong(obj.toString())));
                }
            }

        } else if (obj instanceof Date) {
            date_str=DateUtil.dateToStr((Date) obj);
        } else if ((obj instanceof Integer)||(obj instanceof Long)) {
            date_str=DateUtil.dateToStr(new Date(Long.parseLong(obj.toString())));
        }
        return date_str;
    }
    //将具体值用占位符代替
    public String getPlaceHolder(int type,Object value){
        String placeHolder=null;
        String uuid=null;
        if (type==CommonExample.V) {
            uuid=UUID.randomUUID().toString();
            placeHolder="#{example.map."+uuid+",jdbcType=VARCHAR}";
        }else if(type==CommonExample.D){
            uuid=UUID.randomUUID().toString();
            placeHolder="#{example.map."+uuid+",jdbcType=TIMESTAMP}";
            value=transferTime(value," 00:00:00");
        }else if(type==CommonExample.N){
            uuid=UUID.randomUUID().toString();

            if (Long.class.isInstance(value)){
                placeHolder="#{example.map."+uuid+",jdbcType=BIGINT}";
            }else if (Float.class.isInstance(value)){
                placeHolder="#{example.map."+uuid+",jdbcType=FLOAT}";
            }else if (Integer.class.isInstance(value)){
                placeHolder="#{example.map."+uuid+",jdbcType=INTEGER}";
            }else {
                placeHolder="#{example.map."+uuid+",jdbcType=NUMERIC}";
            }
//			value=Integer.parseInt(value.toString());
        }else{
            //其他类型得数据不予处理
            return placeHolder;
        }
        if(uuid!=null){
            example.setMap(uuid, value);
        }
        return placeHolder;
    }

    //将具体值用占位符代替
    public String getPlaceHolder(int type,Object value,Object obj){
        if(valueIsempty(value)){
            return null;
        }
        String placeHolder=null;
        String uuid=null;
        if (type==CommonExample.V) {
            uuid=UUID.randomUUID().toString();
            placeHolder="#{example.map."+uuid+",jdbcType=VARCHAR}";
        }else if(type==CommonExample.D){
            value=transferTime(value,obj==null?null:obj.toString());
            if(value!=null){
                uuid=UUID.randomUUID().toString();
                placeHolder="#{map."+uuid+",jdbcType=VARCHAR}";
            }
        }else if(type==CommonExample.N){
            uuid=UUID.randomUUID().toString();
            if (Long.class.isInstance(value)){
                placeHolder="#{example.map."+uuid+",jdbcType=BIGINT}";
            }else if (Float.class.isInstance(value)){
                placeHolder="#{example.map."+uuid+",jdbcType=FLOAT}";
            }else if (Integer.class.isInstance(value)){
                placeHolder="#{example.map."+uuid+",jdbcType=INTEGER}";
            }else {
                placeHolder="#{example.map."+uuid+",jdbcType=NUMERIC}";
            }
        }else{
            //其他类型得数据不予处理
            return placeHolder;
        }
        if(uuid!=null){
            example.setMap(uuid, value);
        }
        return placeHolder;
    }
	
	
}
