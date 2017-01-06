<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/view/common/meta.jsp"%>
    <%@ include file="/view/common/admin_head.jsp"%>


    <title>字典管理</title>
        <script type="text/javascript" src="<%=ctx %>/resource/js/content/platform/sysDictionary.js"></script>

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

    <table id="treeGrid" style="width:900px;height:600px" toolbar="#tb"></table>
    <div id="tb" >
        <table class="input">
            <tr>
                <td>
                    <a href="#" class="easyui-linkbutton" plain="true" onclick="refreshTreeGrid()" iconCls="icon-refresh">刷新</a>
                </td>
                <td>
                    <a href="#" class="easyui-linkbutton" plain="true" onclick="addNode()" iconCls="icon-add">新增</a>
                </td>
            </tr>
        </table>
    </div>
    <!-- 编辑窗口 -->
    <div id="editWindow" class="easyui-window" title="新增" modal="true" closed="true" style="padding:10px;" iconCls="icon-add" closed="true" maximizable="false" minimizable="false" collapsible="false">
        <div id="addNode">
            <form id="addForm" method="post" class="jrapid_form">
                <input type="hidden" id="id" name="id" value="">
                <input type="hidden" id="parentId" name="parentId" value="">
                <input type="hidden" id="parentCode" name="parentCode" value="">
                <input type="hidden" id="parentName" name="parentName" value="">
                <table class="input">
                    <tr>
                        <td>
                            <label class="title">字典名称：</label>
                            <input id="name" name="dictName" type="text" value="" class="easyui-validatebox"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="title">字典代码：</label>
                            <input id="code" type="text" name="dictCode" value="" class="easyui-validatebox"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="title">描述：</label>
                            <input id="remark" type="text" name="direction" value="" class="easyui-validatebox"/>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
        <div style="text-align: right;margin-top: 10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'" onclick="saveNode('#add');">保存</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeWin('#add')">取消</a>
        </div>
    </div>
</div>
</body>
</html>
