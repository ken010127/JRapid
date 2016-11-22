<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/view/common/meta.jsp"%>
    <%@ include file="/view/common/admin_head.jsp"%>


    <title>系统模块管理</title>
    <script type="text/javascript" src="<%=ctx %>/resource/js/platform/sysMenu.js"></script>

    <style type="text/css">
        .SelectIcon_ed {
            width: 50px;
            height: 50px;
            padding: 2px 2px 2px 2px;
            border: 2px solid red;
        }

        .SelectIcon {
            width: 50px;
            height: 50px;
            padding: 2px 2px 2px 2px;
            border: 1px solid #000000;
        }
    </style>

</head>
<body>
<div class="easyui-layout" data-options="fit:true">

    <table id="menuTreeGrid" style="width: 900px; height: 600px"
           toolbar="#tb"></table>
    <div id="tb" style="padding: 3px">
        <table class="input">
            <tr>
                <td><a href="#" class="easyui-linkbutton" plain="true"
                       onclick="refreshTreeGrid()" iconcls="icon-refresh">刷新</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true"
                       onclick="addMenu()" iconcls="icon-add">新增</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true"
                       onclick="deleteMenu()" iconcls="icon-remove">删除</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true"
                       onclick="editMenu()" iconcls="icon-edit">修改</a></td>
                <!-- <td><a href="#" class="easyui-linkbutton" plain="true"
                    onclick="sortMenu()" iconcls="icon-sort">排序</a></td> -->
            </tr>
        </table>
    </div>
    <!-- 编辑窗口 -->
    <div id="add" class="easyui-window" title="新增" closed="true"
         modal="true" style="padding: 10px;" iconcls="icon-add" closed="true"
         maximizable="false" minimizable="false" collapsible="false">
        <div id="addSysMenu">
            <form id="addForm">
                <input type="hidden" id="id" name="id" value="">
                <input type="hidden" id="parentId" name="parentId" value="">
                <table class="input">
                    <tr>
                        <th style="width: 50px;">名称：</th>
                        <td><input id="menuName" name="menuName" type="text" value="" class="easyui-validatebox" />
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 50px;">路径：</th>
                        <td><input id="url" name="url" type="text" value="" class="easyui-validatebox" />
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 50px;">序号：</th>
                        <td><input id="orderNo" name="orderNo" type="text" value="" class="easyui-numberbox" />
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 50px;">打开方式：</th>
                        <td>
                            <input id="openType" name="openTypes" size=15/>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
        <div style="text-align: center;">
            <a href="#" class="easyui-linkbutton"
               data-options="iconcls:'icon-save'"
               onclick="saveCondoPrice('#add');">保存</a>
            <a href="#" class="easyui-linkbutton" data-options="iconcls:'icon-cancel'" onclick="closeWin('#add')">取消</a>
        </div>
    </div>


</div>
</body>
</html>
