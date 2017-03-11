/**
 * 页面初始化
 */
jQuery(function($) {

    /*加载权限按钮*/

<#if modelType=="SINGLE_GRID">
    var queryDataGrid = $('#jrapid_datagrid').datagrid({
        singleSelect: true,
        fitColumns: true,
        fit: true,
        rownumbers: true,
        pagination: true,
        striped: true,
        columns: [[<#list tableConfigs as config><#if config.isDisplay=="Y">
            {title:'${config.title}',field:'${config.field}', width:${config.width}<#if (config.dictionary)??>,
                editor:{
                    type:'combobox',
                    options:{
                    data:dictUtils.queryChildrenByCode("${config.dictionary}"),
                    valueField:'dictCode',
                    textField:'dictName',
                    panelHeight:'auto',
                    editable:false
                }
            }</#if>}<#if config_has_next>,</#if></#if></#list>
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
    ${className?uncap_first}Operate.doPageQuery();
</#if>
});