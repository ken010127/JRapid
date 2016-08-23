<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${basePackage}.${modulePackage}.core.dao.${className}Mapper">

	<!-- ********************** 以下部分为代码自动生成，不能修改！！！ ********************************** -->

	<resultMap id="baseResultMap" type="${basePackage}.${modulePackage}.entity.${className}">
        <#list fields as field>
            <#if field.pk>
                <id column="${field.columnName}" property="${field.fieldName}" />      <!-- ${field.comment} -->
            <#else>
		        <result column="${field.columnName}" property="${field.fieldName}"/>		<!-- ${field.comment} -->
			</#if>
		</#list>
	</resultMap>

	<sql id="baseColumnList">
        <#list fields as field>${field.columnName}<#if field_has_next>,<#if ((field_index+1)%5==0)>${"\n\t\t"}</#if></#if></#list>
	</sql>

    <!--根据主键获取记录-->
    <#if (pkColumns?size>1)>
    <select id="findOne" resultMap="baseResultMap" parameterType="HashMap">
        select
            <include refid="baseColumnList" />
        from ${tableName}
        where <#list fields as field> ${field.columnName} = ${r"#"}{${field.fieldName}} <#if field_has_next>,</#if></#list>
    </select>
    <#else>
    <#list fields as field>
    <select id="findOne" resultMap="baseResultMap" parameterType="${field.type}">
        select
            <include refid="baseColumnList" />
        from ${tableName}
        where ${field.columnName} = ${r"#"}{${field.fieldName}}
    </select>
    </#list>
    </#if>

    <!--根据主键删除记录-->
    <#if (pkColumns?size>1)>
    <delete id="delete" parameterType="HashMap">
        delete from ${tableName}
        where <#list fields as field> ${field.columnName} = ${r"#"}{${field.fieldName}} <#if field_has_next>,</#if></#list>
    </delete>
    <#else>
    <#list fields as field>
    <delete id="findOne" resultMap="baseResultMap" parameterType="${field.type}">
        delete from ${tableName}
        where ${field.columnName} = ${r"#"}{${field.fieldName}}
    </delete>
    </#list>
    </#if>

    <!--保存,只针对于一个主键-->
    <#if (pkColumns?size==1)>
	<insert id="save"<#list pkColumns as pk> useGeneratedKeys="false" keyProperty="${pk.fieldName}" parameterType="${basePackage}.${modulePackage}.entity.${className}">
		insert into ${tableName}
		(<include refid="baseColumnList" />
		)
		values
		(	<#list field as field>${r"#"}{${field.fieldName}}<#if field_has_next>,<#if ((field_index+1)%5==0)>${"\n\t\t\t"}</#if></#if></#list>
		)
	</insert>
    </#if>

    <!--更新规定字段-->
	<update id="updateSelected">
		update ${tableName}
		<set>
			<foreach collection="columns" item="column" separator=",">
				<choose>
					<#list fields as field>
                        <#if !field.pk>
					<when test="column=='${field.fieldName}' || column=='${field.columnName}'">
						${field.columnName}=${r"#"}{record.${field.fieldName}}
					</when>
                        </#if>
					</#list>
				</choose>
			</foreach>
		</set>
		where <#list pkColumns as pk>${pk.columnName} = ${r"#"}{record.${pk.fieldName}}</#list>
	</update>

    <!--更新所有字段-->
	<update id="update" parameterType="${basePackage}.${modulePackage}.entity.${className}">
		update ${tableName}
		set <#list fields as field><#if !field.pk>${field.columnName}=${r"#"}{record.${field.fieldName}}<#if field_has_next>,<#if ((field_index+1)%5==0)>${"\n\t\t\t"}</#if></#if></#if></#list>
		where <#list pkColumns as pk>${pk.columnName} = ${r"#"}{record.${pk.fieldName}}</#list>
	</update>
	
	<sql id="exampleClause">
		<trim prefixOverrides="and|or">
			<foreach collection="example.oredCriteria" item="criteria" separator="or">
				<if test="criteria.valid">
					<trim prefix="(" suffix=")" prefixOverrides="and|or">
						<foreach collection="criteria.criteria" item="criterion">
							<choose>
								<when test="criterion.noValue">
									${r"$"}{criterion.condition}
								</when>
							</choose>
						</foreach>
					</trim>
				</if>
			</foreach>
		</trim>
	</sql>
	
	<!-- 根据条件查询 -->
	<select id="listByCondition" resultMap="baseResultMap">
		select 
		<include refid="baseColumnList" />
		from ${tableName}
		<if test="_parameter != null" >
			<where>
				<include refid="exampleClause" />
			</where>
			<if test="example.orderByClause != null and example.orderByClause != ''">
				order by ${r"$"}{example.orderByClause}
			</if>
		</if>
	</select>
	
	<!-- 根据条件查询 -->
	<select id="countByCondition" resultType="java.lang.Integer">
		select count(1)
		from ${tableName}
		<if test="_parameter != null" >
			<where>
				<include refid="exampleClause" />
			</where>
		</if>
	</select>

	<!-- ********************** 以上部分为代码自动生成，不能修改！！！ ********************************** -->

</mapper>