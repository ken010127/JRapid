package com.rbac.jrapid.core.common.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author fwj
 * @date 13-10-30
 */
public class StringUtil {

    /**
     * java特殊字符
     */
    private static final Set<String> KEYWORDS = new HashSet<String>();
    static
    {
        KEYWORDS.add("abstract");
        KEYWORDS.add("boolean");
        KEYWORDS.add("break");
        KEYWORDS.add("byte");
        KEYWORDS.add("case");
        KEYWORDS.add("catch");
        KEYWORDS.add("char");
        KEYWORDS.add("class");
        KEYWORDS.add("const");
        KEYWORDS.add("continue");
        KEYWORDS.add("default");
        KEYWORDS.add("do");
        KEYWORDS.add("double");
        KEYWORDS.add("enum");
        KEYWORDS.add("else");
        KEYWORDS.add("extends");
        KEYWORDS.add("final");
        KEYWORDS.add("finally");
        KEYWORDS.add("float");
        KEYWORDS.add("for");
        KEYWORDS.add("goto");
        KEYWORDS.add("if");
        KEYWORDS.add("implements");
        KEYWORDS.add("import");
        KEYWORDS.add("instanceof");
        KEYWORDS.add("int");
        KEYWORDS.add("interface");
        KEYWORDS.add("long");
        KEYWORDS.add("native");
        KEYWORDS.add("new");
        KEYWORDS.add("package");
        KEYWORDS.add("private");
        KEYWORDS.add("protected");
        KEYWORDS.add("public");
        KEYWORDS.add("return");
        KEYWORDS.add("short");
        KEYWORDS.add("static");
        KEYWORDS.add("strictfp");
        KEYWORDS.add("super");
        KEYWORDS.add("switch");
        KEYWORDS.add("synchronized");
        KEYWORDS.add("this");
        KEYWORDS.add("throw");
        KEYWORDS.add("throws");
        KEYWORDS.add("transient");
        KEYWORDS.add("try");
        KEYWORDS.add("void");
        KEYWORDS.add("volatile");
        KEYWORDS.add("while");
    }

    /**
     * 正则表达式转义字符
     */
    private static final Map<String,String> REGEXKEYWORDS = new HashMap<String, String>();
    static {
        REGEXKEYWORDS.put("(","\\(");
        REGEXKEYWORDS.put(")","\\)");
        REGEXKEYWORDS.put("]","\\]");
        REGEXKEYWORDS.put("[","\\[");
        REGEXKEYWORDS.put("{","\\{");
        REGEXKEYWORDS.put("{","\\}");
        REGEXKEYWORDS.put("\\","\\\\");
    }

    /**
     * 判断一个字符串是否为空，null，空字符串都是空
     *
     * @param s 要判断的字符串
     * @return 空返回true，非空返回false
     */
    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    /**
     * 判断一个字符串是否为空或者由空格组成
     *
     * @param s 要判断的字符串
     * @return 空返回true，非空返回false
     */
    public static boolean isBlank(String s)
    {
        return s == null || s.trim().length() == 0;
    }

    /**
     * 判断一个字符串是不是关键字
     *
     * @param s 要判断的字符串
     * @return 关键字返回true，不是返回false
     */
    public static boolean isKeyword(String s)
    {
        return KEYWORDS.contains(s);
    }

    /**
     * 根据前后缀提取内容
     * @param content 被提取的字符串
     * @param prefix   前缀
     * @param suffix    后缀
     * @return list
     */
   public static List<String> StringExtract(String content,String prefix,String suffix){
       List<String> extracts = new ArrayList<String>();
       String extract;
       //前缀
       String p = REGEXKEYWORDS.get(prefix);
       //后缀
       String s = REGEXKEYWORDS.get(suffix);
       //正则表达式
       String regex = p+"(.*)"+s;
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(content);
       while (matcher.find()) {
           extract=matcher.group();
           //去除前后括号
           extract = extract.substring(1,extract.length()-1);
           extracts.add(extract);
       }
       return extracts;
   }

    /**
     * 得到文件的扩展名.
     *
     * @param fileName
     *            需要处理的文件的名字.
     * @return the extension portion of the file's name.
     */
    public static String getExtension(String fileName) {
        if (fileName != null) {
            int i = fileName.lastIndexOf('.');
            if (i > 0 && i < fileName.length() - 1) {
                return fileName.substring(i + 1).toLowerCase();
            }
        }
        return "";
    }

    /**
     * 得到文件的前缀名.
     * @date 2005-10-18
     *
     * @param fileName
     *            需要处理的文件的名字.
     * @return the prefix portion of the file's name.
     */
    public static String getPrefix(String fileName) {
        if (fileName != null) {
            fileName = fileName.replace("//", "/");

            if(fileName.lastIndexOf("/") > 0) {
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
            }

            int i = fileName.lastIndexOf('.');
            if (i > 0 && i < fileName.length() - 1) {
                return fileName.substring(0, i);
            }
        }
        return "";
    }

    /**
     * 将一个字符串List转化为用“,”分割的字符串
     * @param stringList
     * @return
     */
    public static String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }

}
