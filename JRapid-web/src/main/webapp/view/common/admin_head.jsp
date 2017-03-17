<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 2016/11/14
  Time: 上午9:08
  To change this template use File | Settings | File Templates.
--%>
<% String ctx = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=ctx%>/resource/js/jquery-easyui-1.5/themes/metro/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=ctx%>/resource/js/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=ctx%>/resource/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=ctx%>/resource/css/form_main.css">
<script type="text/javascript" src="<%=ctx%>/resource/js/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/jquery-easyui-1.5/extend/form.extend.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/common/jrapid_ajax_util.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/common/mask.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/common/commonUtils.js"></script>
<script type="text/javascript" src="<%=ctx%>/resource/js/common/totalConstant.js"></script>
<script type="text/javascript">
    var ctx = '<%=request.getContextPath() %>';
    var basePath = '<%=request.getScheme() %>://<%=request.getServerName()%>:<%=request.getServerPort()%>' + ctx;//完整路径带http
    var defaultIconPath = ctx + '/resource/js/jquery-easyui-1.5/themes/icons/';
    var customIconPath = ctx + '/resource/js/jquery-easyui-1.5/themes/customIcon/';
</script>
