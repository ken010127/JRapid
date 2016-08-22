package com.rbac.jrapid.core.db.common;

import com.rbac.jrapid.core.utils.DateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;



public class PresetCriteria extends CommonExample.Criteria implements Serializable{
	/**
	 * 
	 */
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
		String sql=null;
		if (value==null||value.toString().trim().length()<1) {
			return sql;
		}
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
		if(value==null || value.toString().trim().length()<1){
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
			String sql=this.getLikeSQL(CommonExample.OR, columnName, type, str);
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
		

		if(value==null||value.toString().trim().length()<1){
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
		if (value1==null||value2==null) {
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
		if (begindate==null&&enddate==null) {
			return (CommonExample.Criteria)this;
		}
		Date bd=null;
		Date ed=null;
		if (begindate!=null) {
			bd=transferTime(begindate," 00:00:00");
		}
		if (enddate!=null) {
			ed=transferTime(enddate," 00:00:00");
		}
		
		if (bd!=null && ed==null) {
			String placeHolder=this.getPlaceHolder(CommonExample.D, bd);
			sql=" "+andor+" "+columnName+">="+placeHolder+" ";
		} else if (bd==null && ed!=null) {
			String placeHolder=this.getPlaceHolder(CommonExample.D, ed);
			sql=" "+andor+" "+columnName+">="+placeHolder+" ";
		} else if (bd!=null && ed!=null) {
			String placeHolder1=this.getPlaceHolder(CommonExample.D, bd);
			String placeHolder2=this.getPlaceHolder(CommonExample.D, ed);
			sql=" "+andor+" ("+columnName+" >="+placeHolder1+" and "+columnName+"<="+placeHolder2+") ";
		}
		if(sql!=null){
			addCriterion(sql);
		}
		return (CommonExample.Criteria)this;
	
	}
	
	@Override
	public CommonExample.Criteria common(String operate, String andor, String columnName, int type, Object value) {

		String sql=null;
		if (value==null) {
			return (CommonExample.Criteria)this;
		}
		if (value instanceof String&&((String) value).length()<1) {
			return (CommonExample.Criteria)this;
		}
		sql=" "+andor+" "+columnName+operate+getPlaceHolder(type,value)+" ";
		addCriterion(sql);
		return (CommonExample.Criteria)this;
	
	}
	private Date transferTime(Object obj,String attachment) {
		Date date=null;
		String str=obj.toString().trim();
		if ((obj instanceof String)&&(str.length()>0)) {
			boolean flag=true;
			for (char c:(str.toCharArray())) {
				if (c>='0'&&c<='9') {
					continue;
				} else {
					flag=false;
					break;
				}
			}
			if(flag){
				return date;
			}
			if (CommonExample.datepattern.matcher(str).matches()) {
				str=str+attachment;
			} else if (!CommonExample.datetimepattern.matcher(str).matches()) {
				return date;
			} 
			try {
				date= DateUtil.strToDate(str);
			} catch (Exception e) {
				throw new RuntimeException(str+"时间转换异常！", e);
			}
		} else if (obj instanceof Date) {
			date=(Date) obj;
			return date;
		} else if ((obj instanceof Integer)||(obj instanceof Long)) {
			date=new Date(Long.parseLong(obj.toString()));
			return date;
		}
		
		
		return date;
	}
	//将具体值用占位符代替
	public String getPlaceHolder(int type,Object value){
		String placeHolder=null;
		String uuid=null;
		if (type==CommonExample.V) {
			uuid=UUID.randomUUID().toString();
			placeHolder="#{"+uuid+",jdbcType=VARCHAR}";
		}else if(type==CommonExample.D){
			uuid=UUID.randomUUID().toString();
			placeHolder="#{"+uuid+",jdbcType=TIMESTAMP}";
			value=transferTime(value," 00:00:00");
		}else if(type==CommonExample.N){
			uuid=UUID.randomUUID().toString();
			placeHolder="#{"+uuid+",jdbcType=NUMBER}";
			value=Integer.parseInt(value.toString());
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
