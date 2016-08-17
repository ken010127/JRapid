package org.JRapid.generation.utils;

/**
 * 字符串工具类
 * Created by FWJ on 2015/5/8.
 */
public class StringUtil {

    public static final char UNDERLINE='_';

    /**
     * 将单词的首个字母变成大写
     * @param word
     * @return
     */
    public static String upperFirstLetter(String param){
        return param.replaceFirst(param.substring(0, 1),param.substring(0, 1).toUpperCase());
    }

    /**
     * 将驼峰转换成下划线
     * @param param
     * @return
     */
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                if(i!=0)
                    sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转成驼峰写法，首字母大写
     * @param param 字符串
     * @return 字符串
     */
    public static String underlineToCamel(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] words = param.split(String.valueOf(StringUtil.UNDERLINE));

        for(String word:words){
            String lowerWord = word.toLowerCase();
            sb.append(upperFirstLetter(lowerWord));
        }

        return sb.toString();
    }

    /**
     * 下划线转成驼峰写法，首字母小写
     * @param param 字符串
     * @return 字符串
     */
    public static String underlineToCamel1(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        param = param.toLowerCase();
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (c==UNDERLINE){
                if (++i<len){
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
