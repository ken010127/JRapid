package org.JRapid.generation.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Spring mvc + Spring + Mybatis 生成
 * Created by FWJ on 2016/8/19 10:10
 */
public class SSMGenerationImpl extends Generation {
    protected static Logger logger = LoggerFactory.getLogger(SSMGenerationImpl.class);
    @Override
    public void generateEntity(Configuration cfg,List<Entity> entities) {
        try {
            /* 获取模板文件 */
            Template template = cfg.getTemplate(PropertiesUtil.getValue("entity.template"));

            /* 生成输出到文件 */
            File fileDir = new File(PropertiesUtil.getValue("outRoot")+"entity");
            // 创建文件夹，不存在则创建
            org.apache.commons.io.FileUtils.forceMkdir(fileDir);

            for (Entity entity : entities) {
                logger.info("生成 {}.java 开始",entity.getClassName());
                // 指定生成输出的文件
                StringBuilder filePath = new StringBuilder(fileDir.getPath()).append(File.separatorChar).append(entity.getClassName()).append(".java");
                File output = new File(filePath.toString());
                Writer writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                writer.close();
                logger.info("生成{}.java结束！",entity.getClassName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateDao(Configuration cfg,List<Entity> entities) {
        try {
            /* 获取模板文件 */
            Template template = cfg.getTemplate(PropertiesUtil.getValue("dao.template"));

            /* 生成输出到文件 */
            File fileDir = new File(PropertiesUtil.getValue("outRoot")+"dao");
            // 创建文件夹，不存在则创建
            org.apache.commons.io.FileUtils.forceMkdir(fileDir);

            for (Entity entity : entities) {
                logger.info("生成 {}Dao.java 开始",entity.getClassName() );
                // 指定生成输出的文件
                StringBuilder filePath = new StringBuilder(fileDir.getPath()).append(File.separatorChar).append(entity.getClassName()).append("Dao.java");
                File output = new File(filePath.toString());
                Writer writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                writer.close();
                logger.info("生成 {}Dao.java 结束！",entity.getClassName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateService(Configuration cfg,List<Entity> entities) {
        try {
            /* 获取模板文件 */
            Template template = cfg.getTemplate(PropertiesUtil.getValue("service.template"));

            /* 生成输出到文件 */
            File fileDir = new File(PropertiesUtil.getValue("outRoot")+"service");
            // 创建文件夹，不存在则创建
            org.apache.commons.io.FileUtils.forceMkdir(fileDir);

            for (Entity entity : entities) {
                logger.info("生成 {}Service.java 开始",entity.getClassName());
                // 指定生成输出的文件
                StringBuilder filePath = new StringBuilder(fileDir.getPath()).append(File.separatorChar).append(entity.getClassName()).append("Service.java");
                File output = new File(filePath.toString());
                Writer writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                writer.close();
                logger.info("生成 {}Service.java 结束！",entity.getClassName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateController(Configuration cfg,List<Entity> entities) {

    }

    @Override
    public void generateView(Configuration cfg, List<Entity> entities) {

    }

}
