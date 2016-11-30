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
            Template entityTemplate = cfg.getTemplate("entityTemplate.ftl");
            Template requestTemplate = cfg.getTemplate("requestTemplate.flt");
            Template responseTemplate = cfg.getTemplate("responseTemplate.flt");

            String entityPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar +"entity" + File.separatorChar
                    + PropertiesUtil.getValue("modulePackage");
            String requestPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar +"dto" + File.separatorChar
                    + "request" + File.separatorChar + PropertiesUtil.getValue("modulePackage");
            String responsePath = PropertiesUtil.getValue("outRoot")+ File.separatorChar +"dto" + File.separatorChar
                    + "response" + File.separatorChar + PropertiesUtil.getValue("modulePackage");
            // 创建文件夹，不存在则创建
            FileUtils.createFolder(entityPath);
            FileUtils.createFolder(requestPath);
            FileUtils.createFolder(responsePath);

            for (Entity entity : entities) {
                logger.info("生成 {}.java 开始",entity.getClassName());
                File entityOutput = FileUtils.createFile(entityPath + File.separatorChar + entity.getClassName() + ".java");
                writer = new FileWriter(entityOutput);
                entityTemplate.process(entity, writer);
                logger.info("生成{}.java结束！",entity.getClassName());

                logger.info("生成 {}Request.java 开始",entity.getClassName());
                File requestOutput = FileUtils.createFile(requestPath + File.separatorChar + entity.getClassName() + "Request.java");
                writer = new FileWriter(requestOutput);
                requestTemplate.process(entity, writer);
                logger.info("生成{}Request.java结束！",entity.getClassName());

                logger.info("生成 {}Request.java 开始",entity.getClassName());
                File responseOutput = FileUtils.createFile(responsePath + File.separatorChar + entity.getClassName() + "Response.java");
                writer = new FileWriter(responseOutput);
                responseTemplate.process(entity, writer);
                logger.info("生成{}Response.java结束！",entity.getClassName());

                //writer.flush();//输出到控制台
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            assert writer != null;
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


            String daoPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar + "dao" + File.separatorChar
                    + PropertiesUtil.getValue("modulePackage");
            FileUtils.createFolder(daoPath);

            String mapperPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar + "mapper";
            FileUtils.createFolder(mapperPath);

            for (Entity entity : entities) {

                // 指定生成输出的文件
                File dao = new File(daoPath + File.separatorChar + entity.getClassName() + "Mapper.java");
                writer = new FileWriter(dao);
                logger.info("生成 {}Dao.java 开始",entity.getClassName() );
                daoTemplate.process(entity, writer);
                logger.info("生成 {}Dao.java 结束！",entity.getClassName());

                File extDao = new File(daoPath + File.separatorChar + entity.getClassName() + "ExtMapper.java");
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
            assert writer != null;
            writer.close();
        }
    }

    @Override
    public void generateService(Configuration cfg,List<Entity> entities) throws IOException {
        Writer writer = null;
        try {
            /* 获取模板文件 */
            Template serviceTemplate = cfg.getTemplate("serviceMapper.ftl");
            Template serviceImplTemplate = cfg.getTemplate("serviceImplMapper.ftl");

            String servicePath = PropertiesUtil.getValue("outRoot")+ File.separatorChar +  "service" + File.separatorChar
                    + PropertiesUtil.getValue("modulePackage");
            FileUtils.createFolder(servicePath);


            String serviceImplPath = PropertiesUtil.getValue("outRoot")+ File.separatorChar +  "service" + File.separatorChar
                   + "impl" + File.separatorChar + PropertiesUtil.getValue("modulePackage");
            FileUtils.createFolder(serviceImplPath);

            for (Entity entity : entities) {
                logger.info("生成 {}Service.java 开始",entity.getClassName());
                File service = new File(servicePath + File.separatorChar + entity.getClassName() +"Service.java");
                writer = new FileWriter(service);
                serviceTemplate.process(entity, writer);
                logger.info("生成 {}Service.java 结束！",entity.getClassName());

                logger.info("生成 {}ServiceImpl.java 开始",entity.getClassName());
                File serviceImpl = new File(serviceImplPath + File.separatorChar + entity.getClassName() +"ServiceImpl.java");
                writer = new FileWriter(serviceImpl);
                serviceImplTemplate.process(entity, writer);
                logger.info("生成 {}ServiceImpl.java 结束！",entity.getClassName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            assert writer != null;
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
