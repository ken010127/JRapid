package ${basePackage}.dto.request.${modulePackage};

import ${basePackage}.core.dto.request.BaseRequest;
import ${basePackage}.entity.${modulePackage}.${className};

/**
* ${comments}请求类
* @author FWJ
* @since ${.now?datetime}
*/
public class ${className}Request extends BaseRequest {

    private Long id;

    private ${className} ${className?uncap_first};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ${className} get${className}() {
        return ${className?uncap_first};
    }

    public void set${className}(${className} ${className?uncap_first}) {
        this.${className?uncap_first} = ${className?uncap_first};
    }
}
