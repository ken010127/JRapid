/**
 * 
 */
package com.jrapid.common.lang;

import com.jrapid.common.able.ToStringable;
import com.jrapid.common.apache.ToStringBuilder;
import com.jrapid.common.apache.ToStringStyle;

import java.io.Serializable;


/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月16日 下午11:56:52
 */
public class ToString implements ToStringable, Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7273706793161702222L;

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
