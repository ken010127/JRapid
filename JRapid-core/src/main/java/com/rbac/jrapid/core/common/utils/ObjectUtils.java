package com.rbac.jrapid.core.common.utils;

import java.lang.reflect.Array;

/**
 * Object 工具类
 * @author FWJ
 * @since 2017/3/15 下午2:50
 */
public class ObjectUtils {

    /**
     * 判断对象是否是空
     *
     * @param object 传入对象
     *
     * @return 如果<code>object.toString()</code>为<code>""</code>、 <code>null</code> 或者空数组, 则返回<code>true</code>
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            return StringUtils.isEmpty(object.toString());
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }

        return false;
    }


}
