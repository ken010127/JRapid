<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/view/common/meta.jsp"%>
    <%@ include file="/view/common/admin_head.jsp"%>


    <title>系统模块管理</title>
    <script type="text/javascript" src="<%=ctx %>/resource/js/content/platform/sysMenu.js"></script>



</head>
<body>
<div class="easyui-layout" data-options="fit:true">

    <table id="menuTreeGrid" style="width: 900px; height: 600px" toolbar="#tb"></table>
    <div id="tb" style="padding: 3px">
        <table class="input">
            <tr>
                <td><a href="#" class="easyui-linkbutton" plain="true" onclick="refreshTreeGrid()" iconcls="icon-refresh">刷新</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true" onclick="addMenu()" iconcls="icon-add">新增</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true" onclick="deleteMenu()" iconcls="icon-remove">删除</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true" onclick="editMenu()" iconcls="icon-edit">修改</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true" onclick="collapseAll()" iconcls="icon-collapse">折叠</a></td>
                <td><a href="#" class="easyui-linkbutton" plain="true" onclick="expandAll()" iconcls="icon-expand">展开</a></td>
            </tr>
        </table>
    </div>
    <!-- 编辑窗口 -->
    <div id="add" class="easyui-window" title="编辑页面" closed="true"
         modal="true" style="padding: 10px;"  closed="true"
         maximizable="true" minimizable="true" collapsible="false" fit="true">
        <div class="easyui-layout" data-options="fit:true">
            <div class="edit_head" data-options="region:'north',border:false">
                <div style="text-align: right;">
                    <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'" onclick="saveConfig('#add');">保存</a>
                    <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" onclick="closeWin('#add')">取消</a>
                </div>
                <form id="addForm" class="jrapid_form">
                    <input type="hidden" id="id" name="id" value="">
                    <input type="hidden" id="parentId" name="parentId" value="">
                    <table class="input">
                        <tr>
                            <td>
                                <label class="title">名称：</label>
                                <input id="menuName" name="menuName" type="text" value="" class="easyui-validatebox" />
                            </td>
                            <td>
                                <label class="title">模板类型：</label>
                                <input id="modelType" name="modelType"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="title">路径：</label>
                                <input id="url" name="url" type="text" value="" class="easyui-validatebox" />
                            </td>
                            <td>
                                <label class="title">打开方式：</label>
                                <input id="openType" name="openType"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="title">图标：</label>
                                <input id="icon" name="icon" />
                            </td>
                            <td>
                                <label class="title">序号：</label>
                                <input id="orderNo" name="orderNo" type="text" value="" class="easyui-numberbox" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="title">资源树ID：</label>
                                <input id="treeId" name="treeId" />
                            </td>
                            <td>
                                <label class="title">树关联字段：</label>
                                <input id="referField" name="referField" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="title">主表表名：</label>
                                <input id="masterTable" name="masterTable" />
                            </td>
                            <td>
                                <label class="title">主表主键字段：</label>
                                <input id="masterPk" name="masterPk" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="title">从表表名：</label>
                                <input id="slaveTable" name="slaveTable" />
                            </td>
                            <td>
                                <label class="title">从表外键字段：</label>
                                <input id="slaveFk" name="slaveFk" />
                            </td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="edit_head" data-options="region:'center',border:false">
                <div id="tt" class="easyui-tabs" data-options="fit:true" style="padding:10px 0 5px 0;">
                    <div title="按钮设置" fit="true">
                        <table id="sysButtonGrid" style="width:100%;"></table>
                        <div id="buttonTb" style="height:auto">
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="appendButton()">新增</a>
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="reomveButton()">删除</a>
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="endEditing('#sysButtonGrid',buttonIndex)">确定</a>
                        </div>
                    </div>
                    <div title="表格配置信息" style="display:none;" fit="true" >
                        <table id="sysGridConfigGrid" style="width:100%;"></table>
                        <div id="gridConfigTb" style="height:auto">
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="endEditing('#sysGridConfigGrid',gridConfigIndex)">确定</a>
                            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true" onclick="loadClomun()">加载</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>


</div>
</body>
</html>
