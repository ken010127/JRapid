


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
    var requestData = {};
    requestData.sysMenu = select;
    if (select) {
        $.messager.confirm('提示', '确认删除么?', function(data) {
            if(data){
                jrapid_ajax_util.delete('/platform/sysMenu/deleteMenu',requestData,function(data){
                    if (data.status) {
                        $.messager.alert('提示', '删除成功！', 'info');
                        //刷新数据
                        $("#menuTreeGrid").treegrid('reload');
                        //$('#menuTree').tree('reload');
                    } else {
                        parent.$.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
                    }
                });
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
        $('#addForm').form('load',select);
    } else {
        $.messager.alert('warning', '请选择一行数据', 'warning');
    }
}

//保存
function saveCondoPrice(el) {
    var sysMenu = $('#addForm').form('getData',true);
    var requestData = {};
    requestData.sysMenu = sysMenu;
    jrapid_ajax_util.post('/platform/sysMenu/saveMenu',requestData,function(data){
        if (data.status) {
            $('#add').window('close');
            $('#addForm').form('clear');
            parent.$.messager.alert('温馨提示', '保存成功！', 'info');
            //刷新数据
            $("#menuTreeGrid").treegrid('reload');
        } else {
            parent.$.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
        }
    });
}
