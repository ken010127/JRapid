/**
 * 系统菜单
 * Created by fwj on 2016/11/18.
 */
jQuery(function($) {

    $('#menuTreeGrid').treegrid({
        url : ctx + '/platform/sysMenu/getMenuTree',
        idField : 'id',
        treeField : 'menuName',
        fit : true,
        fitColumns : true,
        loadMsg : '数据加载中......',
        columns : [ [ {
            field : 'menuName',
            title : '名称',
            width : 250
        }, {
            field : 'url',
            title : '访问路径',
            width : 280
        }, {
            field : 'orderNo',
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
