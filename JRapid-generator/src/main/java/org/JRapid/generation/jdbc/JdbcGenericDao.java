package org.JRapid.generation.jdbc;

import org.JRapid.generation.constants.ColumnConstants;
import org.JRapid.generation.constants.TableConstants;
import org.JRapid.generation.utils.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC查询类
 * Created by FWJ on 2015/5/7.
 */
public class JdbcGenericDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    /**
     * 获取jdbc connection
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception{
        Class.forName(PropertiesUtil.getValue("jdbc.driver"));
        return DriverManager.getConnection(PropertiesUtil.getValue("jdbc.url"), PropertiesUtil.getValue("jdbc.username"),
                PropertiesUtil.getValue("jdbc.password"));
    }

    /**
     * 关闭数据库链接
     */
    public void closeConn(){
        try{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 查询sql语句
     * @param sql 查询语句
     * @return
     */
    public ResultSet executeSql(String sql){
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取数据库表信息
     * @param tableName 数据库表名，tableName可以模糊查询如：abc%,如果全部查询则直接用 '%' 表示
     * @return 数据库表信息
     */
    public List<Map<String,String>> queryTableInfo(String tableName){
        List<Map<String,String>> tableInfos = new ArrayList<Map<String, String>>();
        try {
            conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            //"%"就是表示*的意思
            rs = metaData.getTables(null, "%",tableName,new String[]{"TABLE"});

            while (rs.next()){
                Map<String,String> table = new HashMap<String, String>();
                //rs.getString(),除此之外还有可以取得TableConstants的其他属性
                table.put(TableConstants.TABLE_NAME,rs.getString(TableConstants.TABLE_NAME));//表名
                table.put(TableConstants.TABLE_TYPE,rs.getString(TableConstants.TABLE_TYPE));//表类型
                table.put(TableConstants.REMARKS,rs.getString(TableConstants.REMARKS));//表备注(注解为空，不知道为什么)

                tableInfos.add(table);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return tableInfos;
    }

    /**
     * 获取表的所有属性
     * @param tableName 表名
     * @return
     */
    public List<Map<String,String>> queryColumnInfos(String tableName){
        List<Map<String,String>> fieldInfos = new ArrayList<Map<String, String>>();
        try {
            conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getColumns(null,"%", tableName,"%");
            while (rs.next()){
                Map<String,String> column = new HashMap<String, String>();
                //字段名
                column.put(ColumnConstants.COLUMN_NAME,rs.getString(ColumnConstants.COLUMN_NAME));
                //字段类型
                column.put(ColumnConstants.TYPE_NAME,rs.getString(ColumnConstants.TYPE_NAME));
                column.put(ColumnConstants.DATA_TYPE,rs.getString(ColumnConstants.DATA_TYPE));
                //字段长度
                int datasize = rs.getInt("COLUMN_SIZE");
                column.put(ColumnConstants.COLUMN_SIZE, Integer.toString(datasize));
                //是否为空，0非空，1为空
                int nullable = rs.getInt("NULLABLE");
                column.put(ColumnConstants.NULLABLE,Integer.toString(nullable));
                fieldInfos.add(column);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fieldInfos;
    }

    /**
     * 获取主键
     * @param talbeName 数据表
     * @return 主键
     */
    public List<String> queryPrimaryKeys(String talbeName){
        List<String> primaryKeys = new ArrayList<String>();
        try {
            conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getPrimaryKeys(null, null, talbeName);
            while (rs.next()){
                primaryKeys.add(rs.getString("COLUMN_NAME"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return primaryKeys;
    }

}
