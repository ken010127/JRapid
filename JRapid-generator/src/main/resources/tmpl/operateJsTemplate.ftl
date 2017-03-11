/**
 * ${title}页面操作方法
 */
${className?uncap_first}Operate = {
    doPageQuery:function(){
        var pageOptions = queryPagination.data("pagination").options;debugger;
        var page = {
            pageSize:pageOptions.pageSize,
            pageNumber:pageOptions.pageNumber
        };
        var queryData = {
            ${className?uncap_first}:$('#query_form').form('getData',true),
            page:page
        };
        //执行分页查询
        dataGridUtils.doPageQuery({
            datagrid:queryDataGrid,
            pagination:queryPagination,
            queryData:queryData,
            url:'${modulePackage}/${className?uncap_first}/pageQuery'
        });
    },
    add${className}:function(){
        var select = queryDataGrid.treegrid('getSelected');
        if (select) {
            $('#modify_Win').window('open');
            $('#modify_Form').form('clear');
        } else {
            $.messager.alert('warning', '请选择一行数据', 'warning');
        }
    },
    modify${className}:function(){
        var select = queryDataGrid.treegrid('getSelected');
        if (select) {
            $('#modify_Win').window('open');
            $('#modify_Form').form('clear');
            $('#modify_Win').mask({maskMsg:'数据加载中！'});
            jrapid_ajax_util.get("${modulePackage}/${className?uncap_first}/get${className}/"+select.id,function (data) {
                if (data.status){
                    $('#modify_Form').form('load',data.${className?uncap_first});
                }else {
                    $.messager.alert('温馨提示', data.errorMsg, 'info');
                }
            });
            $('#modify_Win').mask("hide");
        } else {
            $.messager.alert('warning', '请选择一行数据', 'warning');
        }
    },
    save${className}:function(){
        var requestData = {};
        requestData.${className?uncap_first} = $('#modify_Form').form('getData',true);
        jrapid_ajax_util.post('/${modulePackage}/${className}/save${className}',requestData,function(data){
            if (data.status) {
                $('#modify_Win').window('close');
                $('#modify_Form').form('clear');
                $.messager.show({
                    title:'提示',
                    msg:'保存成功'
                });
                //刷新数据
                ${className?uncap_first}Operate.doPageQuery();
            } else {
                $.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
            }
        });
    },
    delete${className}:function(){
        var select = queryDataGrid.treegrid('getSelected');
        if (select) {
            $.messager.confirm('提示', '确认删除么?', function(data) {
                if(data){
                    jrapid_ajax_util.delete('/platform/sysMenu/deleteMenu/'+select.id,function(data){
                        if (data.status) {
                            $.messager.show({
                                title:'提示',
                                msg:'删除成功'
                            });
                            //刷新数据
                            ${className?uncap_first}Operate.doPageQuery();
                        }else {
                            $.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
                        }
                    });
                }
            });
        } else {
            $.messager.alert('warning', '请选择一行数据', 'warning');
        }
    }
}