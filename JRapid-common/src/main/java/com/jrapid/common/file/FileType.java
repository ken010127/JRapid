/**
 * 
 */
package com.jrapid.common.file;


import com.jrapid.common.able.Valuable;
import com.jrapid.common.file.csv.CsvProcessor;

/**
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年7月27日 上午7:39:28
 */
public enum FileType implements Valuable<String> {
    CSV {
        public FileProcessor createProcessor() {
            return new CsvProcessor();
        }
    },
    XML, PDF, TXT, EXCEL, WORD;

    @Override
    public String value() {
        return this.name().toLowerCase();
    }

    public FileProcessor createProcessor() {
        return null;
    }

}
