/**
 * 系统菜单
 * Created by fwj on 2016/11/18.
 */

//常量，先加载，防止多次向后台提交请求
var buttonIconData;


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


    //初始化按钮图标
    jrapid_ajax_util.get("/platform/sysMenu/getIconNames/default",function (data) {
        if ($.isArray(data)) {
            buttonIconData = data;
        }
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

function selectMenuIcon() {
    $('#iconSelectWin').window('open');
    $('#selectPanel').empty();
    jrapid_ajax_util.get("/platform/sysMenu/getIconNames/custom",function (data) {
        if ($.isArray(data)){
            for (var i in data){
                var src = customIconPath + data[i];
                $("#selectPanel").append("<div class='select_icon'><img src='" + src + "' title='"+data[i]+"' width='20px' height='20px' /></div>");
            }

            $("#selectPanel .select_icon").click(function () {
                var src = $(this).find("img").attr("src");
                var title = $(this).find("img").attr("title").split('.');
                $("#icon").textbox('setValue',title[0]);
                $("#icon_image").attr("src", src);
                $('#iconSelectWin').window('close');
            });
        }else {
            $.messager.alert('warning', '获取图标失败', 'warning');
        }
    });
}

//删除
function deleteMenu() {
    var select = $("#menuTreeGrid").treegrid('getSelected');
    if (select) {
        $.messager.confirm('提示', '确认删除么?', function(data) {
            if(data){
                jrapid_ajax_util.delete('/platform/sysMenu/deleteMenu/'+select.id,function(data){
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

        initButtonGrid();
        initGridConfigGrid();

        //打开方式
        $('#openType').combobox({
            editable : false,
            panelHeight:'auto',
            width:155,
            valueField:'dictCode',
            textField:'dictName',
            data:dictUtils.queryChildrenByCode("MENU_OPEN_TYPE"),
        });

        //模板类型
        $('#modelType').combobox({
            editable:false,
            width:155,
            data:dictUtils.queryChildrenByCode("SYS_TEMPLATE"),
            valueField:'dictCode',
            textField:'dictName',
            panelHeight:'auto'
        });

        $('#add').mask({maskMsg:'数据加载中！'});
        jrapid_ajax_util.get("/platform/sysMenu/getMenuConfigInfo/"+select.id,function (data) {
            if (data.status){
                $('#addForm').form('load',data.sysMenu);
                $("#icon_image").attr("src", customIconPath + data.sysMenu.icon+".png");
                if (data.sysButtons!=undefined && $.isArray(data.sysButtons) && data.sysButtons.length>0){
                    $('#sysButtonGrid').datagrid("loadData",data.sysButtons);
                }
                if (data.sysGridConfigs!=undefined && $.isArray(data.sysGridConfigs) && data.sysGridConfigs.length>0){
                    $('#sysGridConfigGrid').datagrid("loadData",data.sysGridConfigs)
                }
            }else {
                $.messager.alert('温馨提示', data.errorMsg, 'info');
            }
        });
        $('#add').mask("hide");
    } else {
        $.messager.alert('warning', '请选择一行数据', 'warning');
    }
}

//保存
function saveConfig() {
    var sysMenuData = $('#addForm').form('getData',true);

    //结束表格编辑
    if(buttonIndex!=undefined){//有编辑行的时候检验
        if(!$('#sysButtonGrid').datagrid("validateRow",buttonIndex)){
            $.messager.alert("系统提示","按钮设置还有未编辑完!","warning");
            return false;
        }else{
            $("#sysButtonGrid").datagrid("endEdit", buttonIndex);
            buttonIndex = undefined;
        }
    }
    if(gridConfigIndex!=undefined){
        if(!$('#sysGridConfigGrid').datagrid("validateRow",gridConfigIndex)){
            $.messager.alert("系统提示","表格配置信息还有未编辑完!","warning");
            return false;
        }else{
            $("#sysGridConfigGrid").datagrid("endEdit", gridConfigIndex);
            gridConfigIndex = undefined;
        }
    }

    var sysButtonData = $('#sysButtonGrid').datagrid('getRows');
    var gridConfigData = $('#sysGridConfigGrid').datagrid('getRows');

    var requestData = {};
    requestData.sysMenu = sysMenuData;
    requestData.sysButtons = sysButtonData;
    requestData.sysGridConfigs = gridConfigData;

    jrapid_ajax_util.post('/platform/sysMenu/saveMenu',requestData,function(data){
        if (data.status) {
            $('#add').window('close');
            $('#addForm').form('clear');
            $.messager.show({
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
                    type:'combobox',
                    options:{
                        editable:false,
                        //panelWidth:200,
                        onShowPanel:function () {
                            var iconCombo = $('#sysButtonGrid').datagrid('getEditor', {index: buttonIndex,field: 'icon'}).target;
                            iconCombo.combobox('panel').empty();
                            for (var i in buttonIconData) {
                                var src = defaultIconPath + buttonIconData[i];
                                iconCombo.combobox('panel').append("<div class='select_icon'><img class='buttonIcon' src='" + src + "' title='" + buttonIconData[i] + "' width='16px' height='16px' /></div>");
                            }

                            $(".select_icon .buttonIcon").click(function () {
                                var title = $(this).attr("title").split('.');
                                iconCombo.combobox('setValue',title[0]);
                                iconCombo.combobox('setText',title[0]);
                                iconCombo.combobox('hidePanel');
                            });
                        }
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
            {field:'orderNo',title:'序号',width:100,editor:'numberbox'},
            {field:'description',title:'描述',width:200,
                editor: {
                    type:'textbox',
                    options:{
                        required: true
                    }
                }
            }
        ]],
        onDblClickRow:function (index, rowData) {
            if (buttonIndex != index){
                if (endEditing('#sysButtonGrid',buttonIndex)){
                    $('#sysButtonGrid').datagrid('selectRow', index).datagrid('beginEdit', index);

                    $('#sysButtonGrid').datagrid('beginEdit', index);
                    buttonIndex = index;
                } else {
                    setTimeout(function(){
                        $('#sysButtonGrid').datagrid('selectRow', buttonIndex);
                    },0);
                }
            }
        },
        onSelect:function (index,row) {
            endEditing('#sysButtonGrid',buttonIndex);
        }
    });
}

/**
 * 初始化表格配置表格
 */
function initGridConfigGrid(){

    var widgitType = dictUtils.queryChildrenByCode("FROM_WIDGIT");
    var conditionType = dictUtils.queryChildrenByCode("CONDITION_TYPE");
    //头插入一条空数据
    widgitType.unshift({dictName:"--------",dictCode:""});

    $('#sysGridConfigGrid').datagrid({
        fit:true,
        fitColumns:true,
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
            {field:'type',title:'字段类型',width:120,editor:'textbox'},
            {field:'dictionary',title:'字典编码',width:120,editor:'textbox'},
            {field:'orderNo',title:'序号',width:120,editor:'textbox'},
            {field:'isDisplay',title:'是否显示列',width:120,
                editor:{type:'checkbox',options:{on:'Y',off:'N'}}
            },
            {field:'isSearch',title:'是否查询条件',width:120,
                editor:{type:'checkbox',options:{on:'Y',off:'N'}}
            },
            {field:'searchTypeName',title:'查询控件类型',width:120,
                editor:{
                    type:'combobox',
                    options:{
                        data:widgitType,
                        valueField:'dictCode',
                        textField:'dictName',
                        panelHeight:'auto',
                        editable:false
                    }
                }
            },
            {field:'conditionTypeName',title:'查询条件类型',width:120,
                editor:{
                    type:'combobox',
                    options:{
                        data:conditionType,
                        valueField:'dictCode',
                        textField:'dictName',
                        panelHeight:'auto',
                        editable:false
                    }
                }
            },
            {field:'isModify',title:'是否编辑项',width:120,
                editor:{type:'checkbox',options:{on:'Y',off:'N'}}
            },
            {field:'modifyTypeName',title:'编辑控件类型',width:120,
                editor:{
                    type:'combobox',
                    options:{
                        data:widgitType,
                        valueField:'dictCode',
                        textField:'dictName',
                        panelHeight:'auto',
                        editable:false
                    }
                }
            }
        ]],
        onDblClickRow:function (index, rowData) {
            if (gridConfigIndex != index){
                if (endEditing('#sysGridConfigGrid',gridConfigIndex)){
                    $('#sysGridConfigGrid').datagrid('selectRow', index).datagrid('beginEdit', index);

                    $('#sysGridConfigGrid').datagrid('beginEdit', index);
                    gridConfigIndex = index;
                } else {
                    setTimeout(function(){
                        $('#sysGridConfigGrid').datagrid('selectRow', gridConfigIndex);
                    },0);
                }
            }
        },
        onSelect:function (index,row) {
            endEditing('#sysGridConfigGrid',gridConfigIndex);
        },
        onEndEdit:function(index,row) {
            //把combobox设置为显示中文
            var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'searchTypeName'
            });
            if(row.searchTypeName==null || row.searchTypeName!=$(ed.target).combobox('getText')){
                row.searchTypeName = $(ed.target).combobox('getText');
                row.searchType = $(ed.target).combobox('getValue');
            }

            ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'conditionTypeName'
            });
            if(row.conditionTypeName==null || row.conditionTypeName!=$(ed.target).combobox('getText')){
                row.conditionTypeName = $(ed.target).combobox('getText');
                row.conditionType = $(ed.target).combobox('getValue');
            }

            ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'modifyTypeName'
            });
            if(row.modifyTypeName==null || row.modifyTypeName!=$(ed.target).combobox('getText')) {
                row.modifyTypeName = $(ed.target).combobox('getText');
                row.modifyType = $(ed.target).combobox('getValue');
            }
        },
        onLoadSuccess:function(data){
            if (data.rows.length > 0){
                for (var i=0;i<data.rows.length;i++){
                    var detailData = data.rows[i];
                    $(this).datagrid('selectRow',i);
                    $(this).datagrid('beginEdit',i);
                    var searchTypeName = $(this).datagrid('getEditor', {index:i,field:'searchTypeName'});
                    $(searchTypeName.target).combobox('setValue',detailData.searchType);
                    var conditionTypeName = $(this).datagrid('getEditor', {index:i,field:'conditionTypeName'});
                    $(conditionTypeName.target).combobox('setValue',detailData.conditionType);
                    var modifyTypeName = $(this).datagrid('getEditor', {index:i,field:'modifyTypeName'});
                    $(modifyTypeName.target).combobox('setValue',detailData.modifyType);
                    $(this).datagrid('endEdit', i);
                }
            }
        }

    });
}

//gridconfig 编辑列序号
var gridConfigIndex = undefined;
//buttongrid 编辑列序号
var buttonIndex = undefined;
//删除行ID
var deleteButtonIds = new Array();

/**
 * 结束编辑行
 * @param gridId DataGrid ID
 * @param index 行序号
 * @returns {boolean}
 */
function endEditing(gridId,index){
    if (index == undefined){return true}
    if ($(gridId).datagrid('validateRow', index)){
        $(gridId).datagrid('endEdit', index);
        index = undefined;
        return true;
    } else {
        $.messager.alert("系统提示","您还有未编辑完的行!","warning");
        return false;
    }
}

/**
 * 添加按钮编辑行
 */
function appendButton(){
    if (endEditing('#sysButtonGrid',buttonIndex)){
        $('#sysButtonGrid').datagrid('appendRow',{});
        buttonIndex = $('#sysButtonGrid').datagrid('getRows').length-1;
        $('#sysButtonGrid').datagrid('selectRow', buttonIndex).datagrid('beginEdit', buttonIndex);
    }
}

/**
 * 删除按钮行
 */
function reomveButton() {
    var selectRow = $('#sysButtonGrid').datagrid('getSelected');
    if (selectRow){
        var selectIndex = $('#sysButtonGrid').datagrid('getRowIndex',selectRow);
        $('#sysButtonGrid').datagrid('deleteRow', selectIndex);
        if(selectRow.id){
            deleteButtonIds.push(selectRow.id);//添加删除按钮ID
        }
    }else {
        $.messager.alert("系统提示","请选择删除行!","warning");
    }
}

/**
 * 加载数据库表字段信息
 * @returns {boolean}
 */
function loadClomun() {
    var tableName = $('#masterTable').val();

    if (tableName==null || tableName==""){
        $.messager.alert('错误信息', '请填写主表表名！', 'info');
        return false;
    }

    $('#sysGridConfigGrid').datagrid('loading');
    var requestData = {};
    requestData.tableName = tableName;
    jrapid_ajax_util.post('/platform/sysGridConfig/queryColumnInfo',requestData,function(data){
        if (data.status) {
            $('#sysGridConfigGrid').datagrid('loadData',{'rows':data.rows});

        } else {
            $.messager.alert('温馨提示', '加载失败！'+data.errorMsg, 'info');
        }
    });
    $('#sysGridConfigGrid').datagrid('loaded');
}

function collapseAll() {
    $('#menuTreeGrid').treegrid('collapseAll');
}

function expandAll() {
    $('#menuTreeGrid').treegrid('expandAll');
}
