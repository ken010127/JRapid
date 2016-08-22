package com.rbac.jrapid.core.db.common;

import com.rbac.jrapid.core.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class CommonExample implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5578608998289927439L;
	public static final String AND="and";
	public static final String OR="or";
	
	/** 字符varchar */
	public static final int V=1;
	/** 数字number */
	public static final int N=2;
	/** 日期date */
	public static final int D=3;
	
	private int skipNum=0;
	private int rowNum=0;
	
	public static final String ASC="asc";
	public static final String DESC="desc";
	
	private boolean usePreset;
	
	static{
		
	}
//	//SimpleDateFormat线程不安全，使用DateUtil进行优化by pengjingya 2016-02-17
//	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private static SimpleDateFormat formatYYYYMMDD=new SimpleDateFormat("yyyy-MM-dd");
	protected static Pattern datetimepattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([2][0-3])|([1][0-9]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))?))?$");
	protected static Pattern datepattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))");
	
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	private Map<String,Object> map;
	
	public boolean isUsePreset(){
		return usePreset;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(String key,Object value) {
		map.put(key, value);
	}
	public CommonExample() {
		this(true);
	}
	public CommonExample(boolean usePreset) {
		this.usePreset=usePreset;
		if(this.usePreset){
			this.map=new HashMap<String,Object>();
		}
		oredCriteria=new ArrayList<Criteria>();
	}
	public CommonExample(int curPage,int pageNum) {
		this(true);
		if (curPage>0&&pageNum>0) {
			this.skipNum=(curPage-1)*pageNum;
			this.rowNum=curPage*pageNum;
		}
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause=orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct=distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria=createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria=createCriteriaInternal();
		if (oredCriteria.size()==0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria=null;
		if(this.usePreset){
			criteria=new PresetCriteria(this);
		}else{
			criteria=new Criteria();
		}
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause=null;
		distinct=false;
	}
	
	public int getSkipNum() {
		return skipNum;
	}
	public void setSkipNum(int skipNum) {
		this.skipNum=skipNum;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum=rowNum;
	}
	
	public Criteria firstCriteria() {
		if (oredCriteria.size()==0) {
			this.or();
		}
		Criteria Criteria=oredCriteria.get(0);
		return Criteria;
	}
	
	public CommonExample andEqStr(String columnName,Object value) {
		firstCriteria().eq(CommonExample.AND,columnName,CommonExample.V,value);
		return this;
	}
	
	public CommonExample andEqNum(String columnName,Object value) {
		firstCriteria().eq(CommonExample.AND,columnName,CommonExample.N,value);
		return this;
	}
	
	public CommonExample andLeNum(String columnName,Object value) {
		firstCriteria().le(CommonExample.AND,columnName,CommonExample.N,value);
		return this;
	}
	
	public CommonExample andInStr(String columnName,Object value) {
		firstCriteria().in(CommonExample.AND,columnName,CommonExample.V,value);
		return this;
	}
	
	public CommonExample andInNum(String columnName,Object value) {
		firstCriteria().in(CommonExample.AND,columnName,CommonExample.N,value);
		return this;
	}
	public CommonExample andDatebetween(String columnName,Object begindate,Object enddate) {
		firstCriteria().datebetween(CommonExample.AND,columnName,begindate,enddate);
		return this;
	}
	
	public CommonExample andLike(String columnName,Object value) {
		firstCriteria().like(CommonExample.AND,columnName,CommonExample.V,value);
		return this;
	}
	public CommonExample andlLike(String columnName,Object value) {
		firstCriteria().like(CommonExample.AND,columnName,CommonExample.V,value);
		return this;
	}
	public CommonExample andrLike(String columnName,Object value) {
		firstCriteria().like(CommonExample.AND,columnName,CommonExample.V,value);
		return this;
	}
	
	
	public CommonExample andLikes(String columnName,Object value) {
		firstCriteria().likes(CommonExample.AND,columnName,CommonExample.V,value);
		return this;
	}
	
	public CommonExample asc(String columnName) {
		this.orderByClause=columnName+" "+CommonExample.ASC;
		return this;
	}
	
	public CommonExample desc(String columnName) {
		this.orderByClause=columnName+" "+CommonExample.DESC;
		return this;
	}
	
	public CommonExample ascAdd(String columnName) {
		if (!StringUtils.isEmpty(this.orderByClause)) {
			this.orderByClause+=",";
		}
		this.orderByClause+=columnName+" "+CommonExample.ASC;
		return this;
	}
	
	public CommonExample descAdd(String columnName) {
		if (!StringUtils.isEmpty(this.orderByClause)) {
			this.orderByClause+=",";
		}
		this.orderByClause+=columnName+" "+CommonExample.DESC;
		return this;
	}
	
	public static String getBeginDate(Object begindate) {
		if (begindate==null) {
			return "";
		}
		
		String str1="";
		if ((begindate instanceof String)&&(begindate.toString().trim().length()>0)) {
			if (datepattern.matcher(begindate.toString()).matches()) {
				str1=begindate+" 00:00:00";
			} else if (datetimepattern.matcher(begindate.toString()).matches()) {
				str1=begindate.toString();
			} else {
				boolean flag=true;
				for (char c:((String) begindate).toCharArray()) {
					if (c>='0'&&c<='9') {
						continue;
					} else {
						flag=false;
						break;
					}
				}
				if (flag) {
					str1=DateUtil.dateToStr(new Date(Long.parseLong(begindate.toString())));
				}
			}
		} else if (begindate instanceof Date) {
			str1=DateUtil.dateToStr((Date) begindate);
		} else if ((begindate instanceof Integer)||(begindate instanceof Long)) {
			str1=DateUtil.dateToStr(new Date(Long.parseLong(begindate.toString())));
		}
		
		return str1;
	}
	
	public static String getEndDate(Object enddate) {
		if (enddate==null) {
			return "";
		}
		String str2="";
		if ((enddate instanceof String)&&enddate.toString().trim().length()>0) {
			if (datepattern.matcher(enddate.toString()).matches()) {
				str2=enddate+" 23:59:59";
			} else if (datetimepattern.matcher(enddate.toString()).matches()) {
				str2=enddate.toString();
			} else {
				boolean flag=true;
				for (char c:((String) enddate).toCharArray()) {
					if (c>='0'&&c<='9') {
						continue;
					} else {
						flag=false;
						break;
					}
				}
				if (flag) {
					str2=DateUtil.dateToStr(new Date(Long.parseLong(enddate.toString())), "yyyy_MM_dd")+" 23:59:59";
				}
			}
			if (str2.length()<1) {
				System.out.println("value2处理出错");
			}
		} else if (enddate instanceof Date) {
			str2=DateUtil.dateToStr((Date) enddate, "yyyy_MM_dd")+" 23:59:59";
		} else if ((enddate instanceof Integer)||(enddate instanceof Long)) {
			str2=DateUtil.dateToStr(new Date(Long.parseLong(enddate.toString())),"yyyy_MM_dd")+" 23:59:59";
		}
		
		return str2;
	}

	public  static class Criteria implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -3055688113923418427L;

		public Criteria like(String andor,String columnName,int type,Object value) {
			String sql="";
			if (value==null||value.toString().trim().length()<1) {
				return (Criteria)this;
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
			sql=" "+andor+" "+columnName+" like '%"+value.toString().trim().replace("'","''")+"%' ";
			if (isContains) {
				sql = sql + " " + "escape '/'";
			}
			
			addCriterion(sql);
			return (Criteria)this;
		}
		public Criteria lLike(String andor,String columnName,int type,Object value) {
			String sql="";
			if (value==null||value.toString().trim().length()<1) {
				return (Criteria)this;
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
			sql=" "+andor+" "+columnName+" like '%"+value.toString().trim().replace("'","''")+"' ";
			if (isContains) {
				sql = sql + " " + "escape '/'";
			}
			
			addCriterion(sql);
			return (Criteria)this;
		}
		public Criteria rLike(String andor,String columnName,int type,Object value) {
			String sql="";
			if (value==null||value.toString().trim().length()<1) {
				return (Criteria)this;
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
			sql=" "+andor+" "+columnName+" like '"+value.toString().trim().replace("'","''")+"%' ";
			if (isContains) {
				sql = sql + " " + "escape '/'";
			}
			
			addCriterion(sql);
			return (Criteria)this;
		}
		
		/**
		 * value的格式为a,b,c
		 * 返回的sql为 and (columnName like '%a%' or columnName like '%b%' or columnName like '%c%')
		 * czg--2013-7-15上午12:16:35
		 */
		public Criteria likes(String andor,String columnName,int type,Object value) {
			String sql="";
			if (value==null||value.toString().trim().length()<1) {
				return (Criteria)this;
			}
			
			sql=" "+andor+" (";
			
			boolean firstFlag=true;
			for (String str:value.toString().split(",")) {
				if (firstFlag) {
					firstFlag=false;
				} else {
					sql+=" or ";
				}
				sql+=columnName+" like '%"+str.trim().replace("'","''")+"%'";
			}
			
			sql+=") ";
			
			addCriterion(sql);
			return (Criteria)this;
		}
		
		public Criteria in(String andor,String colunnName,int type,Object value){
			if(value==null||value.toString().trim().length()<1){
				return (Criteria)this;
			}
			
			StringBuilder sb=new StringBuilder();
			sb.append(" ").append(andor).append(" ").append(colunnName).append(" in (");
			
			if (value instanceof Collection) {
				if (type==N) {
					sb.append(listToSqlStr((Collection<?>)value, ",", ""));
				} else if (type==V) {
					sb.append(listToSqlStr((Collection<?>)value, ",", "'"));
				}
			} else {
				if (type==N) {
					sb.append(value.toString().trim());
				} else if (type==V) {
					sb.append("'").append(value.toString().trim().replace("'","''").replace(",","','")).append("'");
				}
			}
			sb.append(")");
			
			addCriterion(sb.toString());
			return (Criteria)this;
		}
		
		public Criteria eq(String andor,String columnName,int type,Object value) {
			return(common("=",andor,columnName,type,value));
		}
		
		public Criteria lt(String andor,String columnName,int type,Object value) {
			return(common("<",andor,columnName,type,value));
		}
		
		public Criteria le(String andor,String columnName,int type,Object value) {
			return(common("<=",andor,columnName,type,value));
		}
		
		public Criteria gt(String andor,String columnName,int type,Object value) {
			return(common(">",andor,columnName,type,value));
		}
		
		public Criteria ge(String andor,String columnName,int type,Object value) {
			return(common(">=",andor,columnName,type,value));
		}
		public Criteria neq(String andor,String columnName,int type,Object value) {
			return(common("<>",andor,columnName,type,value));
		}
		
		public Criteria between(String andor,String columnName,int type,Object value1,Object value2) {
			String sql="";
			if (value1==null||value2==null) {
				return (Criteria)this;
			}
			String str1=getValue(type,value1);
			String str2=getValue(type,value2);
			if (str1==null||str2==null) {
				return (Criteria)this;
			}
			sql=" "+andor+" "+columnName+" between("+str1+" and "+str2+") ";
			
			addCriterion(sql);
			return (Criteria)this;
		}
		
		public Criteria datebetween(String andor,String columnName,Object begindate,Object enddate) {
			String sql="";
			if (begindate==null&&enddate==null) {
				return (Criteria)this;
			}
			
			String str1="";
			String str2="";
			if (begindate!=null) {
				if ((begindate instanceof String)&&(begindate.toString().trim().length()>0)) {
					if (datepattern.matcher(begindate.toString()).matches()) {
						str1=begindate+" 00:00:00";
					} else if (datetimepattern.matcher(begindate.toString()).matches()) {
						str1=begindate.toString();
					} else {
						boolean flag=true;
						for (char c:((String) begindate).toCharArray()) {
							if (c>='0'&&c<='9') {
								continue;
							} else {
								flag=false;
								break;
							}
						}
						if (flag) {
							str1= DateUtil.dateToStr(new Date(Long.parseLong(begindate.toString())));
						}
					}
					if (str1.length()<1) {
						System.out.println("value1处理出错;begindate:" + begindate);
						return (Criteria)this;
					}
				} else if (begindate instanceof Date) {
					str1= DateUtil.dateToStr((Date) begindate);
				} else if ((begindate instanceof Integer)||(begindate instanceof Long)) {
					str1=DateUtil.dateToStr(new Date(Long.parseLong(begindate.toString())));
				}
			}
			if (enddate!=null) {
				if ((enddate instanceof String)&&enddate.toString().trim().length()>0) {
					if (datepattern.matcher(enddate.toString()).matches()) {
						str2=enddate+" 23:59:59";
					} else if (datetimepattern.matcher(enddate.toString()).matches()) {
						str2=enddate.toString();
					} else {
						boolean flag=true;
						for (char c:((String) enddate).toCharArray()) {
							if (c>='0'&&c<='9') {
								continue;
							} else {
								flag=false;
								break;
							}
						}
						if (flag) {
							str2=DateUtil.dateToStr(new Date(Long.parseLong(enddate.toString())));
						}
					}
					if (str2.length()<1) {
						System.out.println("value2处理出错");
						return (Criteria)this;
					}
				} else if (enddate instanceof Date) {
					str2=DateUtil.dateToStr((Date) enddate);
				} else if ((enddate instanceof Integer)||(enddate instanceof Long)) {
					str2=DateUtil.dateToStr(new Date(Long.parseLong(enddate.toString())));
				}
			}
			
			if (str1.length()>0&&str2.length()<1) {
				sql=" "+andor+" "+columnName+">="+getDateFunction(str1)+" ";
			} else if (str1.length()<1&&str2.length()>0) {
				sql=" "+andor+" "+columnName+"<="+getDateFunction(str2)+" ";
			} else if (str1.length()>0&&str2.length()>0) {
				sql=" "+andor+" ("+columnName+" >="+getDateFunction(str1)+" and "+columnName+"<="+getDateFunction(str2)+") ";
			}
			
			addCriterion(sql);
			return (Criteria)this;
		}
		
		public Criteria isnull(String andor,String columnName) {
			addCriterion(" "+andor+" "+columnName+" is null ");
			return (Criteria)this;
		}
		public Criteria isNotNull(String andor,String columnName) {
			addCriterion(" "+andor+" "+columnName+" is not null ");
			return (Criteria)this;
		}
		
		public static String orderby(String sortname,String sortorder) {
			String sql="";
			if (sortname!=null&&sortname.length()>0) {
				sql+=" order by "+sortname;
				if (sortorder!=null&&sortorder.length()>0) {
					sql+=" "+sortorder;
				}
				sql+=" ";
			}
			return sql;
		}
		
		public Criteria common(String operate,String andor,String columnName,int type,Object value) {
			String sql="";
			if (value==null) {
				return (Criteria)this;
			}
			if (value instanceof String&&((String) value).length()<1) {
				return (Criteria)this;
			}
			sql=" "+andor+" "+columnName+operate+getValue(type,value)+" ";
			
			addCriterion(sql);
			return (Criteria)this;
		}
		
		private static String getValue(int type,Object value) {
			if (type==CommonExample.V) {
				if (value.toString().length()<1) {
					return null;	
				}
				return "'"+value.toString().trim().replace("'","''")+"'";
			}
			if (type==CommonExample.N) {
				if( value instanceof Number){
					return value.toString();
				}
				boolean flag=true;
				for (char c:((String) value).toCharArray()) {
					if ((c>='0'&&c<='9')||c=='-'||c=='+'||c=='.') {
						continue;
					} else {
						flag=false;
						break;
					}
				}
				if (!flag) {
					return null;
				}
				return value.toString();
			}
			if (type==CommonExample.D) {
				if (value instanceof String) {
					boolean flag=true;
					for (char c:((String) value).toCharArray()) {
						if (c>='0'&&c<='9') {
							continue;
						} else {
							flag=false;
							break;
						}
					}
					if (flag) {
						return getDateFunction(DateUtil.dateToStr(new Date(Long.parseLong(value.toString()))));
					}
					return getDateFunction(value);
				}
				if (value instanceof Date) {
					return getDateFunction(DateUtil.dateToStr((Date) value));
				}
				if ((value instanceof Integer)||(value instanceof Long)) {
					return getDateFunction(DateUtil.dateToStr(new Date(Long.parseLong(value.toString()))));
				}
			}
			
			return null;
		}
		
		protected static String getDateFunction(Object date) {
			return oracle(date);
		}
		
		
		protected static String oracle(Object date) {
			return "to_date('"+date+"','yyyy-mm-dd hh24:mi:ss')";
		}
		
		@SuppressWarnings("unused")
		protected static String sqlserver(Object date) {
			return "cast('"+date+"' as datetime)";
		}
		
		@SuppressWarnings("unused")
		protected static String mysql(Object date) {
			return "'"+date+"'";
		}
		
		protected List<Criterion> criteria;

		protected Criteria() {
			super();
			criteria=new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size()>0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		public void addCriterion(String condition) {
			if (condition==null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		public void addCriterion(String condition,Object value,String property) {
			if (value==null) {
				throw new RuntimeException("Value for "+property+" cannot be null");
			}
			criteria.add(new Criterion(condition,value));
		}

		public void addCriterion(String condition,Object value1,Object value2,String property) {
			if (value1==null||value2==null) {
				throw new RuntimeException("Between values for "+property+" cannot be null");
			}
			criteria.add(new Criterion(condition,value1,value2));
		}
	}

	/*public static class CommonCriteria extends Criteria implements Serializable{

		*//**
		 * 
		 *//*
		private static final long serialVersionUID = -1687561374625297171L;

		protected CommonCriteria() {
			super();
		}
	}*/
/*
	public static class PresetCriteria extends Criteria implements Serializable{
		*//**
		 * 
		 *//*
		private static final long serialVersionUID = -1687561374625297171L;

		protected PresetCriteria() {
			super();
		}
	}*/
	
	public static class Criterion implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -6535093073585881617L;

		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition=condition;
			this.typeHandler=null;
			this.noValue=true;
		}

		protected Criterion(String condition,Object value,String typeHandler) {
			super();
			this.condition=condition;
			this.value=value;
			this.typeHandler=typeHandler;
			if (value instanceof List<?>) {
				this.listValue=true;
			} else {
				this.singleValue=true;
			}
		}

		protected Criterion(String condition,Object value) {
			this(condition,value,null);
		}

		protected Criterion(String condition,Object value,Object secondValue,String typeHandler) {
			super();
			this.condition=condition;
			this.value=value;
			this.secondValue=secondValue;
			this.typeHandler=typeHandler;
			this.betweenValue=true;
		}

		protected Criterion(String condition,Object value,Object secondValue) {
			this(condition,value,secondValue,null);
		}
	}
	
	public static String listToSqlStr(Collection<?> list,String splitChar,String wrapChar) {
		if (list!=null && list.size()<0) {
			return "";
		}
		if (wrapChar==null) {
			wrapChar="";
		}
		StringBuilder sb=new StringBuilder();
		for (Object obj:list) {
			if (sb.length()>0) {
				sb.append(splitChar);
			}
			sb.append(wrapChar).append(obj.toString().replace("'", "''")).append(wrapChar);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(listToSqlStr(Arrays.asList("abc","123","4'56"),",","'"));
	}
}