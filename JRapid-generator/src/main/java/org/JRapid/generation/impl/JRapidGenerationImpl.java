package org.JRapid.generation.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.utils.PropertiesUtil;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;


/**
 * Created by FengWeijian on 2015/5/7.
 */
public class JRapidGenerationImpl extends Generation {
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
                System.out.println("生成："+ entity.getClassName() +".java");
                // 指定生成输出的文件
                StringBuilder filePath = new StringBuilder(fileDir.getPath()).append(File.separatorChar).append(entity.getClassName()).append(".java");
                File output = new File(filePath.toString());
                Writer writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                writer.close();
                System.out.println("生成结束！");
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
                System.out.println("生成："+ entity.getClassName() +"Dao.java");
                // 指定生成输出的文件
                StringBuilder filePath = new StringBuilder(fileDir.getPath()).append(File.separatorChar).append(entity.getClassName()).append("Dao.java");
                File output = new File(filePath.toString());
                Writer writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                writer.close();
                System.out.println("生成结束！");
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
                System.out.println("生成："+ entity.getClassName() +"Service.java");
                // 指定生成输出的文件
                StringBuilder filePath = new StringBuilder(fileDir.getPath()).append(File.separatorChar).append(entity.getClassName()).append("Service.java");
                File output = new File(filePath.toString());
                Writer writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                writer.close();
                System.out.println("生成结束！");
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
    public void generateView(Configuration cfg,List<Entity> entities) {

    }
}
