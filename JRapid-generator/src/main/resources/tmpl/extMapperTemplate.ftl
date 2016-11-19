<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${basePackage}.dao.${modulePackage}.${className}ExtMapper">

    <resultMap id="baseResultExtMap" type="${basePackage}.entity.${modulePackage}.${className}"
               extends="${basePackage}.${modulePackage}.dao.${className}Dao.baseResultMap"></resultMap>

    <sql id="baseExtColumnList">
    <#list fields as field>${field.columnName}<#if field_has_next>,<#if ((field_index+1)%5==0)>${"\n\t\t"}</#if></#if></#list>
    </sql>

</mapper>