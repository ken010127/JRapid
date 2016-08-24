package ${basePackage}.${modulePackage}.dao;

import ${basePackage}.core.common.dao.BaseDao;
import ${basePackage}.${modulePackage}.entity.${className};
import org.springframework.stereotype.Component;

/**
* ${className} ${comments} 持久层操作类
* Created by JRapid on ${.now?datetime}.
*/
@Component("${className}Mapper")
public interface ${className}Dao extends BaseDao<${className},<#if (pkColumns?size>1)>Map<#else>Long</#if>> {

}