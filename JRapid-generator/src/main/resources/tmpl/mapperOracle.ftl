<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${basePack}.${modulePack}.core.dao.${table.tableNameJavaFU}Mapper">

	<!-- ********************** 以下部分为代码自动生成，不能修改！！！ ********************************** -->

	<resultMap id="baseResultMap" type="${basePack}.${modulePack}.api.entity.${table.tableNameJavaFU}">
		<id column="${table.pkColumn.nameLow}" property="${table.pkColumn.nameJavaFL}" />		<!-- ${table.pkColumn.comment} -->
		<#list listMcColumn as column>
			<#if column.nameUp!=table.pkColumn.nameUp>
		<result column="${column.nameLow}" property="${column.nameJavaFL}" />		<!-- ${column.comment} -->
			</#if>
		</#list>
	</resultMap>

	<sql id="baseColumnList">
		<#list listMcColumn as column>${column.nameLow}<#if column_has_next>,<#if ((column_index+1)%5==0)>${"\n\t\t"}</#if></#if></#list>
	</sql>

	<select id="findOne" resultMap="baseResultMap" parameterType="${table.pkColumn.typeJava}">
		select
		<include refid="baseColumnList" />
		from ${table.tableNameLow}
		where ${table.pkColumn.nameLow} = ${r"#"}{${table.pkColumn.nameJavaFL}}
	</select>

	<delete id="delete" parameterType="${table.pkColumn.typeJava}">
		delete from
		${table.tableNameLow}
		where ${table.pkColumn.nameLow} = ${r"#"}{${table.pkColumn.nameJavaFL}}
	</delete>

	<insert id="save" useGeneratedKeys="false" keyProperty="${table.pkColumn.nameJavaFL}" parameterType="${basePack}.${modulePack}.api.entity.${table.tableNameJavaFU}">
		insert into ${table.tableNameLow}
		(<include refid="baseColumnList" />
		)
		values
		(	<#list listMcColumn as column>${r"#"}{${column.nameJavaFL},jdbcType=${column.typeJdbc}}<#if column_has_next>,<#if ((column_index+1)%3==0)>${"\n\t\t\t"}</#if></#if></#list>
		)
	</insert>
	
	<insert id="insertWithSequence" useGeneratedKeys="false" keyProperty="${table.pkColumn.nameJavaFL}" parameterType="${basePack}.${modulePack}.api.entity.${table.tableNameJavaFU}">
		<selectKey resultType="String"  keyProperty="${table.pkColumn.nameJavaFL}" order="BEFORE">
			select seq_${table.tableNameLow}.nextval from dual
		</selectKey>
		insert into ${table.tableNameLow}
		(<include refid="baseColumnList" />
		)
		values
		(	<#list listMcColumn as column>${r"#"}{${column.nameJavaFL},jdbcType=${column.typeJdbc}}<#if column_has_next>,<#if ((column_index+1)%3==0)>${"\n\t\t\t"}</#if></#if></#list>
		)
	</insert>

	<update id="updateSelected">
		update ${table.tableNameLow}
		<set>
			<foreach collection="columns" item="column" separator=",">
				<choose>
					<#list listMcColumn as column>
						<#if column.nameUp!=table.pkColumn.nameUp>
					<when test="column=='${column.nameLow}' || column=='${column.nameJavaFL}'">
						${column.nameLow}=${r"#"}{record.${column.nameJavaFL},jdbcType=${column.typeJdbc}}
					</when>
						</#if>
					</#list>
				</choose>
			</foreach>
		</set>
		where ${table.pkColumn.nameLow} = ${r"#"}{record.${table.pkColumn.nameJavaFL}}
	</update>

	<update id="update" parameterType="${basePack}.${modulePack}.api.entity.${table.tableNameJavaFU}">
		update ${table.tableNameLow}
		set <#list listMcColumn as column>${column.nameLow}=${r"#"}{${column.nameJavaFL},jdbcType=${column.typeJdbc}}<#if column_has_next>,<#if ((column_index+1)%3==0)>${"\n\t\t\t"}</#if></#if></#list>
		where ${table.pkColumn.nameLow} = ${r"#"}{${table.pkColumn.nameJavaFL}}
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
		from ${table.tableNameLow}
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
		from ${table.tableNameLow}
		<if test="_parameter != null" >
			<where>
				<include refid="exampleClause" />
			</where>
		</if>
	</select>
	
	<!-- 根据主键查询自定义列 -->
	<select id="selectColumnsByKey" resultMap="baseResultMap" parameterType="${table.pkColumn.typeJava}">
		select <foreach collection="columns" item="column" separator=",">${r"#"}{column}</foreach>
		from ${table.tableNameLow}
		where ${table.pkColumn.nameLow} = ${r"#"}{${table.pkColumn.nameJavaFL}}
	</select>

	<!-- ********************** 以上部分为代码自动生成，不能修改！！！ ********************************** -->

</mapper>