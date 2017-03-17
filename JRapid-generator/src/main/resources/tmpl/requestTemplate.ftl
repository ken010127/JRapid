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

    private ${className}Condition condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ${className}Condition getCondition() {
        return condition;
    }

    public void set${className}Condition(${className}Condition conditon) {
        this.condition = condition;
    }
}
