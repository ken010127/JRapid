/**
 * 角色管理页面操作方法
 */
sysRoleOperate = {
    doPageQuery:function(){
        var queryDataGrid = $('#jrapid_datagrid');
        var pageOptions = queryDataGrid.datagrid('getPager').data("pagination").options;
        var page = {
            pageSize:pageOptions.pageSize,
            pageNumber:pageOptions.pageNumber
        };
        var queryData = {
            condition:$('#query_form').form('getData',true),
            page:page
        };
        //执行分页查询
        dataGridUtils.doPageQuery({
            datagrid:queryDataGrid,
            pagination:queryDataGrid.datagrid('getPager'),
            queryData:queryData,
            url:'/platform/sysRole/pageQuery'
        });
    },
    addsysRole:function(){
        var select = $('#jrapid_datagrid').datagrid('getSelected');
        if (select) {
            $('#modify_Win').window('open');
            $('#modify_Form').form('clear');
        } else {
            $.messager.alert('warning', '请选择一行数据', 'warning');
        }
    },
    modifysysRole:function(){
        var select = $('#jrapid_datagrid').datagrid('getSelected');
        if (select) {
            $('#modify_Win').window('open');
            $('#modify_Form').form('clear');
            $('#modify_Win').mask({maskMsg:'数据加载中！'});
            jrapid_ajax_util.get("platform/sysRole/getSysRole/"+select.id,function (data) {
                if (data.status){
                    $('#modify_Form').form('load',data.sysRole);
                }else {
                    $.messager.alert('温馨提示', data.errorMsg, 'info');
                }
            });
            $('#modify_Win').mask("hide");
        } else {
            $.messager.alert('warning', '请选择一行数据', 'warning');
        }
    },
    savesysRole:function(){
        var requestData = {};
        requestData.sysRole = $('#modify_Form').form('getData',true);
        jrapid_ajax_util.post('/platform/sysRole/saveSysRole',requestData,function(data){
            if (data.status) {
                $('#modify_Win').window('close');
                $('#modify_Form').form('clear');
                $.messager.show({
                    title:'提示',
                    msg:'保存成功'
                });
                //刷新数据
                sysRoleOperate.doPageQuery();
            } else {
                $.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
            }
        });
    },
    deletesysRole:function(){
        var select = $('#jrapid_datagrid').datagrid('getSelected');
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
                            sysRoleOperate.doPageQuery();
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