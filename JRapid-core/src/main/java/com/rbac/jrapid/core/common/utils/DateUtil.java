package com.rbac.jrapid.core.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期工具类
 * Created by FWJ on 2015/11/18.
 */
public class DateUtil {

    public static String YYYY_MM_DD = "yyyy_MM_dd";

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前年
     * @param date
     * @return
     */
    public static int getYear(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.YEAR);
    }

    /**
     * 获取当前月
     * @param date
     * @return
     */
    public static int getMonth(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MONTH);
    }

    public static int getWeekDay(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取当前日
     * @param date
     * @return
     */
    public static int getDay(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前小时，24小时制
     * @param date
     * @return
     */
    public static int getHour(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前分钟
     * @param date
     * @return
     */
    public static int getMinute(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.MINUTE);
    }

    /**
     * 获取当前秒
     * @param date
     * @return
     */
    public static int getSecond(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.SECOND);
    }

    /**
     * 增加或减少日
     * @param date 当前时间
     * @param num 日数
     * @return
     */
    public static Date plusOrMinusDay(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, num);

        return ca.getTime();
    }

    /**
     * 上一日
     * @param date
     */
    public static Date getLastDay(Date date){
        return plusOrMinusDay(date,-1);
    }

    /**
     * 下一日
     * @param date
     */
    public static Date getNextDay(Date date){
        return plusOrMinusDay(date,1);

    }

    /**
     * 增加或减少周
     * @param date 当前日期
     * @param num 周数
     * @return
     */
    public static Date plusOrMinusWeek(Date date, int num){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.WEEK_OF_MONTH, num);
        return ca.getTime();
    }

    /**
     * 上一周
     * @param date
     * @return
     */
    public static Date getLastWeek(Date date){
        return plusOrMinusWeek(date,-1);
    }

    /**
     * 下一周
     * @param date
     * @return
     */
    public static Date getNextWeek(Date date){
        return plusOrMinusWeek(date,1);
    }

    /**
     * 增加或减少月份
     * @param date
     * @param num
     * @return
     */
    public static Date plusOrMinusMonth(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, num);
        return ca.getTime();
    }

    /**
     * 上一个月
     * @param date
     * @return
     */
    public static Date getLastMonth(Date date){
        return plusOrMinusMonth(date,-1);
    }

    /**
     * 下一个月
     * @param date
     * @return
     */
    public static Date getNextMonth(Date date){
        return plusOrMinusMonth(date,1);
    }

    /**
     * 增加或减少季度
     * @param date
     * @param num
     * @return
     */
    public static Date plusOrMinusQuerter(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, 3*num);
        return ca.getTime();
    }

    /**
     * 上一个季度
     * @param date
     * @return
     */
    public static Date getLastQuarter(Date date){
        return plusOrMinusQuerter(date,-1);
    }

    /**
     * 下一个季度
     * @param date
     * @return
     */
    public static Date getNextQuarter(Date date){
        return plusOrMinusQuerter(date,1);
    }

    /**
     * 增加或减少年份
     * @param date
     * @param num
     * @return
     */
    public static Date plusOrMinusYear(Date date,int num){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.YEAR, num);
        return ca.getTime();
    }

    /**
     * 上一年
     * @param date
     * @return
     */
    public static Date getLastYear(Date date){
        return plusOrMinusYear(date,-1);
    }

    /**
     * 上一年
     * @param date
     * @return
     */
    public static Date getNextYear(Date date){
        return plusOrMinusYear(date,1);
    }

    /**
     * 判断是否周六日
     * @param date
     * @return
     */
    public static boolean checkWeekend(Date date){
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        if(ca.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || ca.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
            return true;
        return false;
    }

    /**
     * 日期转换成字符串
     * @param date
     * @param pattern 时间格式 默认：yyyy-MM-dd HH:mm:ss
     * @return str
     */
    public static String dateToStr(Date date,String pattern) {
        if(pattern==null){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String str = format.format(date);
        return str;
    }

    public static String dateToStr(Date date){
        return dateToStr(date,null);
    }

    /**
     * 字符串转换成日期
     * @param str
     * @param pattern 时间格式 默认：yyyy-MM-dd HH:mm:ss
     * @return date
     */
    public static Date strToDate(String str,String pattern) {
        if(pattern==null){
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToDate(String str){
        return strToDate(str,null);
    }
}
