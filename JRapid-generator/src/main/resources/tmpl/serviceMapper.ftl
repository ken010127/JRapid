package ${basePackage}.service.${modulePackage};

import ${basePackage}.core.common.dao.CommonExample;
import ${basePackage}.entity.${modulePackage}.${className};

/**
* ${comments}逻辑处理接口
* Created by JRapid on ${.now?datetime}
*/
public interface ${className}Service {

    ${className} findOne(Long id) throws java.lang.Exception;

    ${className}Response save(${className} ${className?uncap_first}) throws java.lang.Exception;

    ${className}Response update(${className} ${className?uncap_first}) throws java.lang.Exception;

    ${className}Response updateSelected(${className} ${className?uncap_first}, java.util.List<java.lang.String> list) throws java.lang.Exception;

    ${className}Response delete(Long id) throws java.lang.Exception;

    java.util.List<${className}> listByCondition(CommonExample commonExample) throws java.lang.Exception;

    java.lang.Integer countByCondition(CommonExample commonExample) throws java.lang.Exception;

}
