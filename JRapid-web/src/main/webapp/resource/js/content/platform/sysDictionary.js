var editState = "";

jQuery(function($){

    $('#treeGrid').treegrid({
        url:ctx+"/platform/sysDictionary/queryEasyuiTreeChildren",
        idField:'id',
        treeField:'text',
        fit:true,
        fitColumns:true,
        loadMsg:'数据加载中......',
        columns:[[
            {field:'text',title:'字典名称',width:250},
            {field:'code',title:'字典代码',width:200,align:'right',
                formatter:function(value,row,index){
                    return row.attribute.dictCode;
                }},
            {field:'direction',title:'字典描述',width:280,
                formatter:function(value,row,index){
                    return row.attribute.direction;
                }
            },
            {field:'edit',title:'操作',width:80,
                formatter:function(value,row,index){
                    var link1 = "<a class='editBtn' href='javascript: editNode()'>编辑</a>";
                    var link2 = "<a class='deleteBtn' href='javascript: deleteNode()'>删除</a>";
                    return link1+"  "+link2;
                }
            }
        ]],
        onLoadSuccess:function(data){
            $('.editBtn').linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
            $('.deleteBtn').linkbutton({text:'删除',plain:true,iconCls:'icon-cancel'});
        },
        onBeforeExpand:function(row,param){
            var url = ctx+"/platform/sysDictionary/queryEasyuiTreeChildren?nodeId="+row.id;
            $('#treeGrid').treegrid('options').url= url;
        }
    });

});
function refreshTreeGrid(){
    $("#treeGrid").treegrid('reload',1);
}

function addNode(){
    //修改状态
    editState = "add";

    var select = $("#treeGrid").treegrid('getSelected');
    if(select){debugger;
        $('#editWindow').window('open');
        $('#nodeForm').form('clear');
        $('#parentId').val(select.id);
        $('#parentCode').val(select.attribute.dictCode);
        $('#parentName').val(select.text);
    }else{
        $.messager.alert('warning','请选择一行数据','warning');
    }
}

function deleteNode(){
    var select = $("#treeGrid").treegrid('getSelected');
    var requestData = {};
    requestData.id = select.id;
    if(select){
        $.messager.confirm('confirm','确认删除么?',function(id){
            if(id){
                jrapid_ajax_util.delete('/platform/sysDictionary/deleteSysDictionary',requestData,function(data){
                    if (data.status) {
                        parent.$.messager.show({
                            title:'提示',
                            msg:'删除成功'
                        });
                        //刷新数据
                        $("#treeGrid").treegrid('remove',select.id);
                    } else {
                        parent.$.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
                    }
                });
            }
        });
    }else{
        $.messager.alert('warning','请选择一行数据','warning');
    }
}

function editNode(){
    //修改状态
    editState = "edit";

    var select = $("#treeGrid").treegrid('getSelected');
    $('#editWindow').window('open');
    $('#id').val(select.id);
    $('#parentId').val(select.attribute.parentId);
    $('#parentCode').val(select.attribute.parentCode);
    $('#parentName').val(select.attribute.parentName);
    $('#name').val(select.text);
    $('#code').val(select.attribute.dictCode);
    $('#remark').val(select.attribute.direction);
}

//保存
function saveNode(el) {
    var sysDictionary = $('#addForm').form('getData',true);
    var requestData = {};

    if(sysDictionary.dictCode=="" || sysDictionary.dictCode==null){
        $.messager.alert('温馨提示', '编码不能为空！', 'info');
        return;
    }

    if(sysDictionary.dictName=="" || sysDictionary.dictName==null){
        $.messager.alert('温馨提示', '名称不能为空！', 'info');
        return;
    }

    requestData.sysDictionary = sysDictionary;
    var select = $("#treeGrid").treegrid('getSelected');
    jrapid_ajax_util.post('/platform/sysDictionary/saveSysDictionary',requestData,function(data){
        if (data.status) {
            $('#editWindow').window('close');
            $('#addForm').form('clear');
            $.messager.show({
                title:'提示',
                msg:'保存成功'
            });
            //刷新数据
            if(editState == "add"){
                if(select.children==null ||select.children.length==null || select.children.length==0){
                    var p = $("#treeGrid").treegrid('getParent',select.id);
                    if(p==null){
                        $("#treeGrid").treegrid('reload');
                    }else{
                        $("#treeGrid").treegrid('reload',p.id);
                    }
                }else{
                    $("#treeGrid").treegrid('reload',select.id);
                }
            }else if(editState == "edit"){
                var p = $("#treeGrid").treegrid('getParent',select.id);
                $("#treeGrid").treegrid('reload',p.id);
            }
        } else {
            $.messager.alert('温馨提示', '保存失败！'+data.errorMsg, 'info');
        }
    });
}
