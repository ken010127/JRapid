package com.jrapid.common.ip;


import com.jrapid.common.apache.ToStringBuilder;
import com.jrapid.common.apache.ToStringStyle;

/**
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月16日 上午12:52:39
 */
public class LineEntity {

    private String line;
    private boolean isFinished;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public byte[] getBytes() {
        return (line + "\n").getBytes();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
