package ${basePackage}.${modulePackage}.entity;


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
    @pk
    </#if>
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