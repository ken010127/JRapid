package org.JRapid.generation.impl;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.utils.ConverterUtil;
import org.JRapid.generation.utils.PropertiesUtil;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.Locale;

/**
 * 模板模式生成模板
 * Created by FWJ on 2015/5/7.
 */
public abstract class Generation {

    public final void generate(){
        try {
            Configuration cfg = new Configuration();
            cfg.setEncoding(Locale.getDefault(), "UTF-8");
            cfg.setDirectoryForTemplateLoading(new File(PropertiesUtil.getValue("templateRoot")));

            cfg.setObjectWrapper(new DefaultObjectWrapper());

            ConverterUtil converter = new ConverterUtil();
            List<Entity> entities = converter.convert();

            //生成实体
            if("true".equals(PropertiesUtil.getValue("entity.isGenerate"))){
                generateEntity(cfg,entities);
            }

            //生成Dao
            if("true".equals(PropertiesUtil.getValue("dao.isGenerate"))){
                generateDao(cfg,entities);
            }

            //生成Service
            if("true".equals(PropertiesUtil.getValue("service.isGenerate"))){
                generateService(cfg,entities);
            }

            //生成Controller
            if("true".equals(PropertiesUtil.getValue("controller.isGenerate"))){
                generateController(cfg,entities);
            }

            //生成View
            if("true".equals(PropertiesUtil.getValue("view.isGenerate"))){
                generateView(cfg,entities);
            }

            hook();//挂钩
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void generateEntity(Configuration cfg,List<Entity> entities);

    public abstract void generateDao(Configuration cfg,List<Entity> entities);

    public abstract void generateService(Configuration cfg,List<Entity> entities);

    public abstract void generateController(Configuration cfg,List<Entity> entities);

    public abstract void generateView(Configuration cfg,List<Entity> entities);

    public void hook(){}

}
