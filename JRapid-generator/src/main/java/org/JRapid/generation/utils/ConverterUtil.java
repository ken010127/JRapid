package org.JRapid.generation.utils;

import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.bean.Field;
import org.JRapid.generation.constants.ColumnConstants;
import org.JRapid.generation.constants.TableConstants;
import org.JRapid.generation.jdbc.JdbcGenericDao;
import org.JRapid.generation.jdbc.JdbcTypesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 转换器，将表结构转换成javabean
 * Created by FengWeijian on 2015/5/8.
 */
public class ConverterUtil {

    /**
     * 将表结构转换成javabean
     * @return Entity
     */
    /*public List<Entity> convert(String tableNames){
        JdbcGenericDao dao = new JdbcGenericDao();
        List<Entity> entities = new ArrayList<Entity>();

        List<Map<String,String>> tables = dao.queryTableInfo(tableNames);

        for (Map<String,String> table:tables){
            Entity entity = new Entity();
            entity.setDbType(PropertiesUtil.getValue("jdbc.dbType"));
            entity.setBasePackage(PropertiesUtil.getValue("basePackage"));
            entity.setModulePackage(PropertiesUtil.getValue("modulePackage"));
            String tableName = table.get(TableConstants.TABLE_NAME);
            entity.setClassName(StringUtil.underlineToCamel(tableName));
            entity.setTableName(tableName);
            entity.setComments(table.get(TableConstants.REMARKS));

            List<Field> fields = new ArrayList<Field>();
            List<Map<String,String>> columns = dao.queryColumnInfos(tableName);
            List<Field> pkColumns = new ArrayList<Field>();
            List<String> pks = dao.queryPrimaryKeys(tableName);

            for (Map<String,String> column:columns){
                Field field = new Field();

                field.setColumnName(column.get(ColumnConstants.COLUMN_NAME));
                field.setComments(column.get(ColumnConstants.REMARKS));
                field.setFieldName(StringUtil.underlineToCamel1(column.get(ColumnConstants.COLUMN_NAME)));

                Integer type = Integer.parseInt(column.get(ColumnConstants.DATA_TYPE));
                field.setType(JdbcTypesUtils.jdbcTypeToJavaType(type).getName());

                //设置是否是主键
                if(pks.contains(column.get(ColumnConstants.COLUMN_NAME))){
                    field.setPk(true);
                    pkColumns.add(field);
                }else{
                    field.setPk(false);
                }
                fields.add(field);
            }
            entity.setPkColumns(pkColumns);
            entity.setFields(fields);
            entities.add(entity);
        }
        return entities;
    }*/



}
