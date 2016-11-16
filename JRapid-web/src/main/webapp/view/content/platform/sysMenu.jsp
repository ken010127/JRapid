<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/view/common/meta.jsp"%>
    <%@ include file="/view/common/admin_head.jsp"%>


    <title>系统模块管理</title>
    <script type="text/javascript">
        jQuery(function($) {

            $('#menuTreeGrid').treegrid({
                url : ctx + '/sysMenu/getMenuTree',
                idField : 'id',
                treeField : 'name',
                fit : true,
                fitColumns : true,
                loadMsg : '数据加载中......',
                columns : [ [ {
                    field : 'name',
                    title : '名称',
                    width : 250
                }, {
                    field : 'location',
                    title : '访问路径',
                    width : 280
                }, {
                    field : 'levelOrder',
                    title : '序号',
                    width : 50
                } ] ]

            });

            $("#openType").combobox({
                editable : false,
                panelHeight:80,
                width:155,
                valueField:'value',
                textField:'text',
                data:[
                    {
                        value:1,
                        text:'本窗口'
                    },{
                        value:2,
                        text:'新窗口'
                    }]
            });

        });
        //刷新
        function refreshTreeGrid() {
            $("#menuTreeGrid").treegrid('reload');
        }

        //新增
        function addMenu() {
            var select = $("#menuTreeGrid").treegrid('getSelected');
            if (select) {
                $('#add').window('open');
                $('#condoPriceForm').form('clear');
                $('#parentId').val(select.id);
                $('#openType').combobox('setValue',1);
            } else {
                $.messager.alert('warning', '请选择一行数据', 'warning');
            }
        }

        //删除
        function deleteMenu() {
            var select = $("#menuTreeGrid").treegrid('getSelected');
            if (select) {
                $.messager.confirm('confirm', '确认删除么?', function(id) {
                    if (id) {
                        $.ajax({
                            type : 'POST',
                            url : ctx + '/menuInfo/menuInfoDelete.action',
                            data : {
                                "menu.id" : select.id
                            },
                            dataType : 'json',
                            success : function(data) {
                                if (data.success) {
                                    $.messager.alert('提示', '删除成功！', 'info');
                                    //刷新数据
                                    $("#menuTreeGrid").treegrid('reload');
                                    //$('#menuTree').tree('reload');
                                } else {
                                    $.messager.alert('温馨提示', data.message,
                                            'info');
                                }
                            }
                        });
                        $('#menuTreeGrid').treegrid('reload');
                    }
                });
            } else {
                $.messager.alert('warning', '请选择一行数据', 'warning');
            }
        }

        //修改
        function editMenu() {
            var select = $("#menuTreeGrid").treegrid('getSelected');
            if (select) {
                $('#add').window('open');
                $('#id').val(select.id);
                $('#parentId').val(select.parentId);
                $('#name').val(select.name);
                $('#location').val(select.location);
                $('#levelOrder').val(select.levelOrder);
                $('#openType').combobox('setValue',select.openType);
            } else {
                $.messager.alert('warning', '请选择一行数据', 'warning');
            }
        }

        //保存
        function saveCondoPrice(el) {
            var openNewWindow;

            $.ajax({
                type : 'POST',
                url : ctx + '/menuInfo/menuInfoSave.action',
                dataType : 'json',
                data : {
                    "menu.id" : $('#id').val(),
                    "menu.name" : $('#name').val(),
                    "menu.location" : $('#location').val(),
                    "menu.levelOrder" : $('#levelOrder').val(),
                    "menu.parentId" : $('#parentId').val(),
                    "menu.openType" :  $('#openType').combobox('getValue')
                },
                success : function(data) {
                    if (data.success) {
                        $('#add').window('close');
                        //刷新数据
                        $("#menuTreeGrid").treegrid('reload');
                        //$('#menuTree').tree('reload');
                    } else {
                        parent.$.messager.alert('温馨提示', '保存成功！', 'info');
                    }
                }
            });
        }

        function closeWin(el) {
            $(el).window('close');
        }
    </script>

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
        <div id="addConPrice">
            <form id="condoPriceForm" method="post" class="form">
                <input type="hidden" id="id" name="menu.id" value=""> <input
                    type="hidden" id="parentId" name="menu.parentid" value="">
                <table class="input">
                    <tr>
                        <th style="width: 50px;">名称：</th>
                        <td><input id="name" name="menu.name" type="text" value=""
                                   class="easyui-validatebox" />
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 50px;">路径：</th>
                        <td><input id=location name="menu.location" type="text" value=""
                                   class="easyui-validatebox" />
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 50px;">序号：</th>
                        <td><input id="levelOrder" type="text" value=""
                                   class="easyui-numberbox" />
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 50px;">打开方式：</th>
                        <td>
                            <input id="openType" size=15/>

                        </td>
                    </tr>
                </table>
            </form>

        </div>
        <div style="text-align: center;">
            <a href="#" class="easyui-linkbutton"
               data-options="iconcls:'icon-save'"
               onclick="saveCondoPrice('#add');">保存</a> <a href="#"
                                                           class="easyui-linkbutton" data-options="iconcls:'icon-cancel'"
                                                           onclick="closeWin('#add')">取消</a>
        </div>
    </div>


</div>
</body>
</html>
