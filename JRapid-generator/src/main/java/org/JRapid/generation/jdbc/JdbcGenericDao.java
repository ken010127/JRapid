package org.JRapid.generation.jdbc;

import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.bean.Field;
import org.JRapid.generation.bean.Model;
import org.JRapid.generation.bean.TableConfig;
import org.JRapid.generation.constants.ColumnConstants;
import org.JRapid.generation.constants.TableConstants;
import org.JRapid.generation.utils.PropertiesUtil;
import org.JRapid.generation.utils.StringUtil;

import java.sql.*;
import java.util.*;

/**
 * JDBC查询类
 * Created by FWJ on 2015/5/7.
 */
public class JdbcGenericDao {

    Connection conn = null;

    /**
     * 获取jdbc connection
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception{
        Connection conn = null;
        Properties props =new Properties();
        try {
            Class.forName(PropertiesUtil.getValue("jdbc.driver"));
            props.setProperty("user", PropertiesUtil.getValue("jdbc.username"));
            props.setProperty("password", PropertiesUtil.getValue("jdbc.password"));
            props.setProperty("remarks", "true"); //设置可以获取remarks信息
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息

            conn = DriverManager.getConnection(PropertiesUtil.getValue("jdbc.url"),props);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库链接
     */
    public void closeConn(Statement stmt,ResultSet rs){
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
        Statement stmt = null;
        ResultSet rs = null;
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
    public List<Entity> queryTableInfo(String tableName) throws SQLException {
        List<Entity> entities = new ArrayList<Entity>();
        ResultSet rs = null;
        try {
            conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            //"%"就是表示*的意思
            rs = metaData.getTables(null, "%",tableName,new String[]{"TABLE"});

            while (rs.next()){
                Entity entity = new Entity();
                entity.setDbType(PropertiesUtil.getValue("jdbc.dbType"));
                entity.setBasePackage(PropertiesUtil.getValue("basePackage"));
                entity.setModulePackage(PropertiesUtil.getValue("modulePackage"));
                //rs.getString(),除此之外还有可以取得TableConstants的其他属性
                entity.setTableName(rs.getString(TableConstants.TABLE_NAME));//表名
                entity.setClassName(StringUtil.underlineToCamel(rs.getString(TableConstants.TABLE_NAME)));
                entity.setDbType(rs.getString(TableConstants.TABLE_TYPE));//表类型
                entity.setComments(rs.getString(TableConstants.REMARKS));//表备注(注解为空，不知道为什么)

                List<Field> fields = this.queryColumnInfos(entity.getTableName());
                List<String> pks = this.queryPrimaryKeys(entity.getTableName());

                List<Field> pkColumns = new ArrayList<Field>();
                for (Field field : fields){
                    if(pks.contains(field.getColumnName())){
                        field.setPk(true);
                        pkColumns.add(field);
                    }else{
                        field.setPk(false);
                    }
                }

                entity.setPkColumns(pkColumns);
                entity.setFields(fields);

                entities.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
        }
        return entities;
    }

    /**
     * 获取表的所有字段属性
     * @param tableName 表名
     * @return
     */
    public List<Field> queryColumnInfos(String tableName) throws SQLException {
        List<Field> fieldInfos = new ArrayList<Field>();
        ResultSet rs = null;
        try {
            conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getColumns(null,"%", tableName,"%");
            while (rs.next()){
                Field field = new Field();
                //字段名
                field.setColumnName(rs.getString(ColumnConstants.COLUMN_NAME));
                field.setComments(rs.getString(ColumnConstants.REMARKS));
                field.setFieldName(StringUtil.underlineToCamel1(rs.getString(ColumnConstants.COLUMN_NAME)));

                Integer type = Integer.parseInt(rs.getString(ColumnConstants.DATA_TYPE));
                field.setType(JdbcTypesUtils.jdbcTypeToJavaType(type).getName());

                //字段长度
                //int datasize = rs.getInt("COLUMN_SIZE");
                //是否为空，0非空，1为空
                //int nullable = rs.getInt("NULLABLE");
                fieldInfos.add(field);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rs.close();
        }
        return fieldInfos;
    }

    /**
     * 获取主键
     * @param talbeName 数据表
     * @return 主键
     */
    public List<String> queryPrimaryKeys(String talbeName) throws SQLException {
        List<String> primaryKeys = new ArrayList<String>();
        ResultSet rs = null;
        try {
            conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getPrimaryKeys(null, null, talbeName);
            while (rs.next()){
                primaryKeys.add(rs.getString("COLUMN_NAME"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rs.close();
        }
        return primaryKeys;
    }

    /**
     * 查询模块配置信息
     * @param tableName 表名
     * @return 模块配置信息
     */
    public List<Model> queryModels(String tableName){
        List<Model> models = new ArrayList<Model>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            String queryModel = "select * from sys_menu where master_table=?";
            String queryTableConfig = "select * from sys_grid_config where refer_id=? order by order_no";
            conn = getConnection();
            pstmt = conn.prepareStatement(queryModel);
            pstmt.setString(1,tableName);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Model model = new Model();
                model.setId(rs.getLong("id"));
                model.setClassName(StringUtil.underlineToCamel(tableName));
                model.setTitle(rs.getString("menu_name"));
                model.setModulePackage(PropertiesUtil.getValue("modulePackage"));
                model.setModelType(rs.getString("model_type"));
                model.setTreeId(rs.getLong("tree_id"));
                model.setReferField(rs.getString("refer_field"));
                model.setMasterTable(rs.getString("master_table"));
                model.setMasterPk(rs.getString("master_pk"));
                model.setSlaveTable(rs.getString("slave_table"));
                model.setSlaveFk(rs.getString("slave_fk"));

                Connection configConn = getConnection();
                PreparedStatement configStmt = configConn.prepareCall(queryTableConfig);
                configStmt.setLong(1,model.getId());
                ResultSet configReslut = configStmt.executeQuery();
                List<TableConfig> tableConfigs = new ArrayList<TableConfig>();
                while (configReslut.next()){
                    TableConfig tableConfig = new TableConfig();
                    tableConfig.setGridType(configReslut.getString("grid_type"));
                    tableConfig.setTitle(configReslut.getString("title"));
                    tableConfig.setField(configReslut.getString("field"));
                    tableConfig.setProperty(tableConfig.getField());
                    tableConfig.setWidth(configReslut.getInt("width"));
                    tableConfig.setDictionary(configReslut.getString("dictionary"));
                    tableConfig.setIsDisplay(configReslut.getString("is_display"));
                    tableConfig.setIsSearch(configReslut.getString("is_search"));
                    tableConfig.setSearchType(configReslut.getString("search_type"));
                    tableConfig.setIsModify(configReslut.getString("is_modify"));
                    tableConfig.setModifyType(configReslut.getString("modify_type"));
                    tableConfig.setAllowNull(configReslut.getString("allow_null"));
                    tableConfigs.add(tableConfig);
                }
                model.setTableConfigs(tableConfigs);
                models.add(model);
                configStmt.close();
                configConn.close();
            }

        } catch (ClassNotFoundException e) {//捕获驱动加载失败异常
            e.printStackTrace();
        } catch (SQLException e) {//捕获SQL语句执行失败异常
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {//恢复变量初始值
            try {
                if(pstmt != null) {
                    pstmt.close();
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {//捕获SQL异常
                e.printStackTrace();
            }
        }
        return models;
    }
}
