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

        initButtonGrid();
        initGridConfigGrid();

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
                        parent.$.messager.show({
                            title:'提示',
                            msg:'删除成功'
                        });
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
function saveCondoPrice() {
    var sysMenu = $('#addForm').form('getData',true);
    var requestData = {};
    requestData.sysMenu = sysMenu;
    jrapid_ajax_util.post('/platform/sysMenu/saveMenu',requestData,function(data){
        if (data.status) {
            $('#add').window('close');
            $('#addForm').form('clear');
            parent.$.messager.show({
                title:'提示',
                msg:'保存成功'
            });
            //刷新数据
            $("#menuTreeGrid").treegrid('reload');
        } else {
            parent.$.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
        }
    });
}

/**
 * 初始化按钮表格
 */
function initButtonGrid() {
    $('#sysButtonGrid').datagrid({
        fit:true,
        fitColumns:true,
        pagination:true,//分页控件
        pageSize:20,
        pageList: [20, 50, 100],//可以设置每页记录条数的列表
        rownumbers:true,//行号
        collapsible: true,
        singleSelect:true,
        toolbar:'#buttonTb',
        loadMsg:'数据加载中......',
        url:ctx+'',
        columns:[[
            {field:'buttonName',title:'按钮名称',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'icon',title:'图标',width:100,
                editor:{
                    type:'textbox',
                    options:{
                        editable:false,
                        icons:[{
                            iconCls:'icon-search',
                            handler:function(){
                                //selectIcon();//选择图标
                            }
                        }]
                    }
                }
            },
            {field:'event',title:'按钮触发事件',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'widgetId',title:'按钮ID',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'orderNo',title:'序号',width:100,
                editor: {
                    type:'numberbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'description',title:'描述',width:200,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            }
        ]]
    });
}

/**
 * 初始化表格配置表格
 */
function initGridConfigGrid(){
    $('#sysGridConfigGrid').datagrid({
        fit:true,
        fitColumns:true,
        pagination:true,//分页控件
        pageSize:20,
        pageList: [20, 50, 100],//可以设置每页记录条数的列表
        rownumbers:true,//行号
        collapsible: true,
        singleSelect:true,
        toolbar:'#gridConfigTb',
        loadMsg:'数据加载中......',
        columns:[[
            {field:'field',title:'字段名',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'title',title:'列名称',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'width',title:'列宽',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'dictionary',title:'字典编码',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'orderNo',title:'序号',width:120,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            },
            {field:'isDisplay',title:'是否显示列',width:120,
                editor:{type:'checkbox',options:{on:'Y',off:'N'}}
            },
            {field:'isSearch',title:'是否查询条件',width:120,
                editor:{type:'checkbox',options:{on:'Y',off:'N'}}
            },
            {field:'searchType',title:'查询控件类型',width:120,
                editor:{
                    type:'combobox',
                    readonly:true,
                    options:{
                        //data:spo_form_util.getDictByCode("SPO_DIFFERENCE_MODE"),
                        valueField:'value',
                        textField:'name',
                        panelHeight:'auto',
                        editable:false,
                        required: true
                    }
                }
            },
            {field:'isModify',title:'是否编辑项',width:120,
                editor:{type:'checkbox',options:{on:'Y',off:'N'}}
            },
            {field:'modifyType',title:'编辑控件类型',width:120,
                editor:{
                    type:'combobox',
                    readonly:true,
                    options:{
                        //data:spo_form_util.getDictByCode("SPO_DIFFERENCE_MODE"),
                        valueField:'value',
                        textField:'name',
                        panelHeight:'auto',
                        editable:false,
                        required: true
                    }
                }
            }
        ]]
    });
}
