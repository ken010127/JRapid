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
            </tr>
        </table>
    </div>
    <!-- 编辑窗口 -->
    <div id="add" class="easyui-window" title="编辑页面" closed="true"
         modal="true" style="padding: 10px;"  closed="true"
         maximizable="true" minimizable="true" collapsible="false" fit="true">
        <div id="addSysMenu">
            <form id="addForm">
                <input type="hidden" id="id" name="id" value="">
                <input type="hidden" id="parentId" name="parentId" value="">
                <table class="input">
                    <tr>
                        <td style="width: 50px;">名称：</td>
                        <td><input id="menuName" name="menuName" type="text" value="" class="easyui-validatebox" />
                        </td>
                        <td style="width: 50px;">模板类型：</td>
                        <td><input id="modelType" name="modelType" type="text" value="" class="easyui-validatebox" />
                        </td>
                    </tr>

                    <tr>
                        <td style="width: 50px;">路径：</td>
                        <td><input id="url" name="url" type="text" value="" class="easyui-validatebox" />
                        </td>
                        <td style="width: 50px;">打开方式：</td>
                        <td>
                            <input id="openType" name="openTypes" size=15/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50px;">图标：</td>
                        <td>
                            <input id="icon" name="icon" size=15/>
                        </td>
                        <td style="width: 50px;">序号：</td>
                        <td><input id="orderNo" name="orderNo" type="text" value="" class="easyui-numberbox" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50px;">资源树ID：</td>
                        <td>
                            <input id="treeId" name="treeId" size=15/>
                        </td>
                        <td style="width: 50px;">树关联字段</td>
                        <td>
                            <input id="referField" name="referField" size=15/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50px;">主表表名</td>
                        <td>
                            <input id="masterTable" name="masterTable" size=15/>
                        </td>
                        <td style="width: 50px;">主表主键字段</td>
                        <td>
                            <input id="masterPk" name="masterPk" size=15/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50px;">主表表名</td>
                        <td>
                            <input id="slaveTable" name="slaveTable" size=15/>
                        </td>
                        <td style="width: 50px;">主表主键字段</td>
                        <td>
                            <input id="slaveFk" name="slaveFk" size=15/>
                        </td>
                    </tr>

                </table>
            </form>
            <div id="tt" class="easyui-tabs" style="width:99%;height:99%;">
                <div title="按钮设置">
                    <table id="sysButtonGrid"></table>
                    <div id="buttonTb" style="height:auto">
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendButton()">新增</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="reomveButton()">删除</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="endEditing('#sysButtonGrid',buttonIndex)">确定</a>
                    </div>
                </div>
                <div title="表格配置信息" style="display:none;">
                    <table id="sysGridConfigGrid"></table>
                    <div id="gridConfigTb" style="height:auto">
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="endEditing('#sysGridConfigGrid',gridConfigIndex)">确定</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true" onclick="loadClomun()">加载</a>
                    </div>
                </div>
            </div>
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
