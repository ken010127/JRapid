package ${basePackage}.dto.response.${modulePackage};

import ${basePackage}.core.dto.response.BaseResponse;
import ${basePackage}.entity.${modulePackage}.${className};

/**
* ${comments}返回类
* @author FWJ
* @since ${.now?datetime}
*/
public class ${className}Response extends BaseResponse {

    private ${className} ${className?uncap_first};

    public ${className} get${className}() {
        return ${className?uncap_first};
    }

    public void set${className}(${className} ${className?uncap_first}) {
        this.${className?uncap_first} = ${className?uncap_first};
    }
}
