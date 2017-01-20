package com.rbac.jrapid.core.common.utils;

/**
 * java类获取web应用的根目录
 * 获取当前运行文件所在目录，根据路径中包含的特殊字符串进行分割
 * @author FWJ
 * @since 2017/1/18 下午3:17
 */
public class PathUtil {

    public static String getWebClassesPath() {
        String path = PathUtil.class.getProtectionDomain().getCodeSource()
                .getLocation().getPath();
        return path;
    }

    public static String getWebInfPath() throws IllegalAccessException {
        String path = getWebClassesPath();
        if (path.indexOf("WEB-INF") > 0) {
            path = path.substring(0, path.indexOf("WEB-INF") + 8);
        } else {
            throw new IllegalAccessException("路径获取错误");
        }
        return path;
    }

    public static String getWebRoot() throws IllegalAccessException{
        String path = getWebClassesPath();
        if (path.indexOf("WEB-INF") > 0) {
            path = path.substring(0, path.indexOf("WEB-INF/classes"));
        } else {
            throw new IllegalAccessException("路径获取错误");
        }
        return path;
    }

}
