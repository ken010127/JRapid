java web 项目开发
Spring + mybatis + bootstrap

1、使用 twitter的snowflake 分布式主键生成
IdWorker.getId();

2、使用 Twitter tower 工具来管理 js包
使用tower前要先安装 node.js

3、前端UI框架使用：EasyUI（考虑用bootstrap中的AdminLTE2前端框架，但是bootstrap控件不全，很多地方需要改动）

4、spring mvc 请求使用Restful格式
创建资源 : 使用 HTTP POST
获取资源 : 使用 HTTP GET
更新资源 : 使用 HTTP PUT
删除资源 : 使用 HTTP DELETE

5、使用自定义代码生成工具 JRapid-generator 自动生成
 暂时只支持 mybatis orm 框架的生成
 配置文件 generation-config 可以修改要生成代码的数据库，要生成那些模板

6、数据流走向
dto+(vo)+po
在业务不复杂的情况下，把vo省略，直接dto+po（业务不复杂情况下，vo与po基本上是一样的所以暂时省略vo）
dto中包含Request、Response两种类型，一个是请求数据，一个是返回数据

7、前端页面生成，直接根据配置表生成出JSP、js文件
不考虑使用同一模板，主要考虑到两点：
（1）使用同一模板，现实页面时都要查询数据库再根据数据生成出页面，影响页面加载时间
（2）如果使用同一模板，修改页面时灵活性不够，而且如果有些特殊修改同一模板不好修改
前端页面主要有以下几种类型：
（1）DataGrid
（2）TreeGrid （业务需求使用比较小，一次性加载全部数据，如有需要异步加载再手工修改）
（3）Tree + DataGrid （左边树右边表格）
（4）主从表结构，上边主表信息，下边明细表格 （主要用于单据）