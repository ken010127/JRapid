package ${basePackage}.service.impl.${modulePackage};

import ${basePackage}.core.common.dao.CommonExample;
import ${basePackage}.dao.${modulePackage}.${className}Mapper;
import ${basePackage}.dao.${modulePackage}.${className}ExtMapper;
import ${basePackage}.entity.${modulePackage}.${className};
import ${basePackage}.service.${modulePackage}.${className}Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ${comments}逻辑处理实现类
* Created by JRapid on ${.now?datetime}
*/
@Service("${className}Service")
public class ${className}ServiceImpl implements ${className}Service{
    protected static Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);

    @Autowired
    public ${className}Mapper ${className?uncap_first}Mapper;

    @Autowired
    public ${className}ExtMapper ${className?uncap_first}ExtMapper;

    public ${className} findOne(Long id) throws Exception {
        return ${className?uncap_first}Mapper.findOne(id);
    }

    public ${className}Response save(${className} ${className?uncap_first}) throws Exception {
        ${className}Response response = new ${className}Response();
        int result;
        if (${className?uncap_first}.getId()==null){
            result = ${className?uncap_first}Mapper.save(${className?uncap_first});
        }else {
            result = ${className?uncap_first}Mapper.update(${className?uncap_first});
        }

        if (result<0){
            response.setStatus(false);
        }
        response.set${className}(${className?uncap_first});
        return response;
    }

    public ${className}Response update(${className} ${className?uncap_first}) throws Exception {
        ${className}Response response = new ${className}Response();
        int result = ${className?uncap_first}Mapper.update(${className?uncap_first});;

        if (result<0){
            response.setStatus(false);
        }
        response.set${className}(${className?uncap_first});
        return response;
    }

    public ${className}Response updateSelected(${className} ${className?uncap_first}, List<String> list) throws Exception {
        ${className}Response response = new ${className}Response();
        int result = ${className?uncap_first}Mapper.updateSelected(${className?uncap_first},list);
        if (result<0){
            response.setStatus(false);
        }
        response.set${className}(${className?uncap_first});
        return response;
    }

    public ${className}Response delete(Long id) throws Exception {
        ${className}Response response = new ${className}Response();
        int result = ${className?uncap_first}Mapper.delete(id);
        if (result<0){
            response.setStatus(false);
        }
        return response;
    }

    public List<${className}> listByCondition(CommonExample commonExample) throws Exception {
        return ${className?uncap_first}Mapper.listByCondition(commonExample);
    }

    public Integer countByCondition(CommonExample commonExample) throws Exception {
        return ${className?uncap_first}Mapper.countByCondition(commonExample);
    }

}
