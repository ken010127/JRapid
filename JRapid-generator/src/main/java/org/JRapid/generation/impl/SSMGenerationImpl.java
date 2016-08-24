package org.JRapid.generation.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.JRapid.generation.bean.Entity;
import org.JRapid.generation.utils.FileUtils;
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
    public void generateEntity(Configuration cfg,List<Entity> entities) throws IOException {
        Writer writer = null;
        try {
            /* 获取模板文件 */
            Template template = cfg.getTemplate("entityTemplate.ftl");

            String directoryPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar +"entity";
            // 创建文件夹，不存在则创建
            FileUtils.createFolder(directoryPath);

            for (Entity entity : entities) {
                logger.info("生成 {}.java 开始",entity.getClassName());
                // 指定生成输出的文件
                File output = FileUtils.createFile(directoryPath + File.separatorChar + entity.getClassName() + ".java");
                writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                logger.info("生成{}.java结束！",entity.getClassName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    @Override
    public void generateDao(Configuration cfg,List<Entity> entities) throws IOException {
        Writer writer = null;
        try {
            /* 获取模板文件 */
            Template daoTemplate = cfg.getTemplate("mybatisDaoTemplate.ftl");
            Template extDaoTemplate = cfg.getTemplate("mybatisExtDaoTemplate.ftl");
            Template mapperTemplate = cfg.getTemplate("mapperTemplate.ftl");
            Template extMapperTemplate = cfg.getTemplate("extMapperTemplate.ftl");


            String daoPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar + "dao";
            FileUtils.createFolder(daoPath);

            String mapperPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar + "mapper";
            FileUtils.createFolder(mapperPath);

            for (Entity entity : entities) {

                // 指定生成输出的文件
                File dao = new File(daoPath + File.separatorChar + entity.getClassName() + "Dao.java");
                writer = new FileWriter(dao);

                logger.info("生成 {}Dao.java 开始",entity.getClassName() );
                daoTemplate.process(entity, writer);
                logger.info("生成 {}Dao.java 结束！",entity.getClassName());

                File extDao = new File(daoPath + File.separatorChar + entity.getClassName() + "ExtDao.java");
                writer = new FileWriter(extDao);
                logger.info("生成 {}ExtDao.java 开始",entity.getClassName() );
                extDaoTemplate.process(entity, writer);
                logger.info("生成 {}ExtDao.java 结束！",entity.getClassName());

                File mapper = new File(mapperPath + File.separatorChar + entity.getClassName() + "Mapper.xml");
                writer = new FileWriter(mapper);
                logger.info("生成 {}Mapper.xml 开始",entity.getClassName() );
                mapperTemplate.process(entity, writer);
                logger.info("生成 {}Mapper.xml 结束！",entity.getClassName());

                File extMapper = new File(mapperPath + File.separatorChar + entity.getClassName() + "ExtMapper.xml");
                writer = new FileWriter(extMapper);
                logger.info("生成 {}ExtMapper.xml 开始",entity.getClassName() );
                extMapperTemplate.process(entity, writer);
                logger.info("生成 {}ExtMapper.xml 结束！",entity.getClassName());

                //writer.flush();//输出到控制台
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    @Override
    public void generateService(Configuration cfg,List<Entity> entities) throws IOException {
        Writer writer = null;
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

                writer = new FileWriter(output);
                template.process(entity, writer);
                //writer.flush();//输出到控制台
                logger.info("生成 {}Service.java 结束！",entity.getClassName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    @Override
    public void generateController(Configuration cfg,List<Entity> entities) throws IOException {

    }

    @Override
    public void generateView(Configuration cfg, List<Entity> entities) throws IOException {

    }

}
