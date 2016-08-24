<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${basePackage}.${modulePackage}.core.dao.${className}ExtMapper">

    <resultMap id="baseResultExtMap" type="${basePackage}.${modulePackage}.entity.${className}"
               extends="${basePackage}.${modulePackage}.core.dao.${className}Mapper.baseResultMap"></resultMap>

</mapper>