package org.JRapid.generation.impl;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.bean.Model;
import org.JRapid.generation.jdbc.JdbcGenericDao;
import org.JRapid.generation.utils.ConverterUtil;
import org.JRapid.generation.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * 模板模式生成模板
 * Created by FWJ on 2015/5/7.
 */
public abstract class Generation {

    protected static Logger logger = LoggerFactory.getLogger(Generation.class);

    public final void generate(){
        try {
            //配置文件修改每次都要重新打包，直接写在java里编译直接可以运行
            //要生成的table，可以用%表示全部
            String tableNames = "sys_role";

            Configuration cfg = new Configuration();
            cfg.setEncoding(Locale.getDefault(), "UTF-8");
            cfg.setDirectoryForTemplateLoading(new File(PropertiesUtil.getValue("templateRoot")));
            cfg.setObjectWrapper(new DefaultObjectWrapper());

            JdbcGenericDao dao = new JdbcGenericDao();

            List<Entity> entities = null;
            try {
                entities = dao.queryTableInfo(tableNames);
            } catch (SQLException e) {
                logger.error("查询"+tableNames+"失败！");
                e.printStackTrace();
            }

//            PropertiesUtil.getValue("entity.isGenerate")
            //生成实体
//            generateEntity(cfg,entities);

            //生成Dao
//            generateDao(cfg,entities);

            //生成Service
//            generateService(cfg,entities);

            //生成Controller
            generateController(cfg,entities);

            //生成View
//            List<Model> models = dao.queryModels(tableNames);
//            generateView(cfg,models);

            hook();//挂钩
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void generateEntity(Configuration cfg,List<Entity> entities)  throws IOException;

    public abstract void generateDao(Configuration cfg,List<Entity> entities) throws IOException;

    public abstract void generateService(Configuration cfg,List<Entity> entities) throws IOException;

    public abstract void generateController(Configuration cfg,List<Entity> entities) throws IOException;

    public abstract void generateView(Configuration cfg,List<Model> models) throws IOException;

    /**
     * 添加配置信息（spring的配置文件）
     * @param entities 实体信息
     * @throws IOException
     */
    public abstract void generateConfig(List<Entity> entities) throws IOException;

    public void hook(){}

}
