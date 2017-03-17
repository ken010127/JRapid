/**
 * 页面初始化
 */
jQuery(function($) {

    /*调整高度*/
    var dataHeight = $("#jrapid_main_data").height();
    $("#jrapid_main_data div[name='jrapid_datagrid_panel']").height(dataHeight-32);

    /*加载权限按钮*/
    var buttonSpan = $("#jrapid_main_head div[name='jrapid_title'] span");
    buttonSpan.empty();
    buttonSpan.append("<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-search' onclick='submitForm()'>查询</a>");
    buttonSpan.append("<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-down' onclick='submitForm()'>导入</a>");
    buttonSpan.append("<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-up' onclick='submitForm()'>导出</a>");
    //渲染easyui控件
    $.parser.parse(buttonSpan);

    var queryDataGrid = $('#jrapid_datagrid').datagrid({
        singleSelect: true,
        fitColumns: true,
        fit: true,
        rownumbers: true,
        pagination: true,
        striped: true,
        columns: [[
            {title:'角色名称',field:'role_name', width:120},
            {title:'描述',field:'description', width:120},
            {title:'创建人',field:'create_user', width:120},
            {title:'创建时间',field:'create_time', width:120}
        ]]
    });

    //设置分页控件
    var queryPagination = queryDataGrid.datagrid('getPager');
    $(queryPagination).pagination({
        pageSize: 20,//每页显示的记录条数，默认为10
        pageList: [20,50,100],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        /*onBeforeRefresh:function(){
        $(this).pagination('loading');
        alert('before refresh');
        $(this).pagination('loaded');
        }*/
    });

    /*执行查询*/
    sysRoleOperate.doPageQuery();
});