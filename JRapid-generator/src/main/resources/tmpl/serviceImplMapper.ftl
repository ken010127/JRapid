package ${basePackage}.service.impl.${modulePackage};

import ${basePackage}.dao.${modulePackage}.${className}Mapper;
import ${basePackage}.dao.${modulePackage}.${className}ExtMapper;
import ${basePackage}.entity.${modulePackage}.${className};
import ${basePackage}.service.${modulePackage}.${className}Service;
import ${basePackage}.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* ${comments}逻辑处理实现类
* Created by JRapid on ${.now?datetime}
*/
@Transactional
@Service("${className}Service")
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Mapper,${className}>
                                    implements ${className}Service{
    protected static Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);

    @Autowired
    public ${className}ExtMapper ${className?uncap_first}ExtMapper;

}
