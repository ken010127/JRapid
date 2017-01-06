package ${basePackage}.entity.${modulePackage};

import ${basePackage}.core.db.mybatis.annotation.PK;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.rbac.jrapid.core.common.annotation.CHILDREN;
import com.rbac.jrapid.core.common.annotation.ORDERID;
import com.rbac.jrapid.core.common.annotation.PARENTID;
import com.rbac.jrapid.core.db.mybatis.annotation.PK;

import java.io.Serializable;

/**
* ${comments}实体类
* Created by JRapid on ${.now?datetime}.
*/
public class ${className} implements Serializable {

    <#list fields as field>
    public final static String ${field.columnName?upper_case} = "${field.columnName}";
    </#list>

    <#list fields as field>
    /**
    * ${field.comments}
    **/
    <#if field.pk>
    @PK
    </#if>
    @JsonSerialize(using=ToStringSerializer.class)
    private ${field.type} ${field.fieldName};

    </#list>

    <#list fields as field>
    public ${field.type} get${field.fieldName?cap_first}(){
        return ${field.fieldName};
    }

    public void set${field.fieldName?cap_first}(${field.type} ${field.fieldName}){
        this.${field.fieldName} = ${field.fieldName};
    }

    </#list>
}