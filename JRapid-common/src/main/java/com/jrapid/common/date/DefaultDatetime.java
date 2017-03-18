package com.jrapid.common.date;

import com.jrapid.common.date.format.Formatter;
import com.jrapid.common.date.format.ISO8601Formatter;

import java.util.Locale;
import java.util.TimeZone;


/**
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月22日 下午5:13:42
 */
public class DefaultDatetime {

    public static boolean monthFix = true;

    public static TimeZone timeZone; // system default

    public static Locale locale; // system default

    public static String format = DatetimeObject.DEFAULT_FORMAT;

    public static Formatter formatter = new ISO8601Formatter();

    public static int firstDayOfWeek = DatetimeObject.MONDAY;

    public static int mustHaveDayOfFirstWeek = 4;

    public static int minDaysInFirstWeek = 4;

    public static boolean trackDST;
}
