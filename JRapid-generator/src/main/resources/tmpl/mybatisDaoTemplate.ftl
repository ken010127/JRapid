package ${basePackage}.dao.${modulePackage};

import ${basePackage}.core.common.dao.BaseMapper;
import ${basePackage}.entity.${modulePackage}.${className};
import org.springframework.stereotype.Component;

/**
* ${className} ${comments} 持久层操作类
* Created by JRapid on ${.now?datetime}.
*/
@Component("${className}Mapper")
public interface ${className}Mapper extends BaseMapper<${className},<#if (pkColumns?size>1)>Map<#else>Long</#if>> {

}