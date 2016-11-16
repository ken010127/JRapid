<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath", basePath);
%>

<script type="text/javascript" src="${basePath}js/html5/html5shiv.js"></script>
<script type="text/javascript" src="${basePath}js/jquery.form.js"></script>
<script language="javascript" src="${basePath}js/My97DatePicker/WdatePicker.js"></script>
<script language="JavaScript" src="${basePath}js/mouse.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.3.3/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}js/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${basePath}js/common.js"></script>

<link rel="stylesheet" type="text/css" href="${basePath}js/uploadify/uploadify.css" />
<script type="text/javascript" src="${basePath}js/uploadify/jquery.uploadify.min.js"></script>
<link  href="${basePath}js/easyvalidator/css/validate.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${basePath}js/easyvalidator/js/jquery.bgiframe.min.js" ></script>
<script type="text/javascript" src="${basePath}js/easyvalidator/js/easy_validator.pack.js" ></script>
<link href="${basePath}js/jquery.stepy-1.1.0/css/jquery.stepy.css" rel="stylesheet" type="text/css" />
<script charset="utf-8" src="${basePath}js/jquery.stepy-1.1.0/js/jquery.stepy.js"></script>


<style type="text/css">
	.label{float: left;width:150px;text-align: right;}
	.redFont{color:red}
	.grayFont{color:gray}
	.disnone{display:none}
</style>