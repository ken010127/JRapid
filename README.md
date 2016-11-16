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