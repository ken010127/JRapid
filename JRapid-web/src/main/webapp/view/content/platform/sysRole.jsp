<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/view/common/meta.jsp"%>
    <%@ include file="/view/common/admin_head.jsp"%>

    <title>角色管理</title>
    <script type="text/javascript" src="<%=ctx %>/resource/js/content/platform/sysRole_init.js"></script>
    <script type="text/javascript" src="<%=ctx %>/resource/js/content/platform/sysRole_operate.js"></script>
</head>
<body>
    <div name="jrapid_main" class="easyui-layout" data-options="fit:true">
        <div id="jrapid_main_head" data-options="region:'north',border:false" style="height:80px">
            <div name="jrapid_title" class="jrapid_title">
                <font class="jrapid_title_name">查询条件</font>
                <span style="float:right;"></span>
            </div>
            <div name="jrapid_query_condition" class="jrapid_query_condition">
                <form id="query_form" class="query_form">
                    <div name="jrapid_form_container" class="jrapid_form_container">
                        <ul>
                            <li>
                                <label class="title">角色名称:</label>
                                <input class="easyui-textbox" id="query_role_name" name="roleName"/>
                            </li>
                            <li>
                                <label class="title">创建时间:</label>
                                <input class="easyui-datetimebox" id="query_start_time" name="startTime"/>-
                                <input class="easyui-datetimebox" id="query_end_time" name="endTime"/>
                            </li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
        <div id="jrapid_main_data" data-options="region:'center',border:false">
            <div name="jrapid_title" class="jrapid_title">
                <font class="jrapid_title_name">角色管理列表</font>
            </div>
            <div name="jrapid_datagrid_panel" fit="true">
                <table id="jrapid_datagrid"></table>
            </div>
        </div>
    </div>

    <!--编辑窗口-->
    <div id="modify_Win" class="easyui-window" title="角色管理编辑页面" closed="true"
         modal="true" style="padding: 10px;width: auto;"  closed="true"
         maximizable="true" minimizable="true" collapsible="false" fit="true">
        <div style="padding:10px 10px">
            <form id="modify_Form" method="post">
                <!--隐藏字段-->
                <input type="hidden" id="modify_id" name="id"/>
                <input type="hidden" id="modify_modify_time" name="modify_time"/>
                <input type="hidden" id="modify_modify_user" name="modify_user"/>
                <input type="hidden" id="modify_create_user" name="create_user"/>
                <input type="hidden" id="modify_create_time" name="create_time"/>

                <table>
                    <tr>
                        <td>角色名称:</td>
                        <td><input class="easyui-validatebox" type="text" name="role_name" </input></td>
                    </tr>
                        <td>描述:</td>
                        <td><input class="easyui-textbox" type="text" name="description" </input></td>
                    </tr>
                </table>
            </form>
            <div style="text-align:center;padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重设</a>
            </div>
        </div>
    </div>

</body>
</html>