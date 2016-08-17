package org.JRapid.generation.constants;

/**
 * JDBC数据字段对应的相关属性
 * Created by FWJ on 2015/5/7.
 */
public class ColumnConstants {

    /**
     * column name
     */
    public static final String COLUMN_NAME = "COLUMN_NAME";

    /**
     * SQL type from java.sql.Types
     * return int
     */
    public static final String DATA_TYPE = "DATA_TYPE";

    /**
     * Data source dependent type name, for a UDT the type name is fully qualified
     */
    public static final String TYPE_NAME = "TYPE_NAME";

    /**
     * column size
     * return int
     */
    public static final String COLUMN_SIZE = "COLUMN_SIZE";

    /**
     * is NULL allowed
     * return int (以下的是常量)
     * 0非空，1为空
     */
    public static final String NULLABLE = "NULLABLE";

    /**
     * comment describing column (may be null)
     */
    public static final String REMARKS = "REMARKS";

    /**
     * default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null)
     */
    public static final String COLUMN_DEF = "COLUMN_DEF";

    /**
     * Indicates whether this column is auto incremented
     * return String
     * YES --- if the column is auto incremented
     * NO --- if the column is not auto incremented
     * empty string --- if it cannot be determined whether the column is auto incremented parameter is unknown
     */
    public static final String IS_AUTOINCREMENT = "IS_AUTOINCREMENT";
}
