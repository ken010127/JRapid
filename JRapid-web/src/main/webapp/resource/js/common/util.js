/**
 * treeGrid转换
 */
function treeGridConvert(rows){
	if(rows==null) return null;
    function exists(rows, parentId){
        for(var i=0; i<rows.length; i++){
            if (rows[i].id == parentId) return true;
        }
        return false;
    }

    var nodes = [];
    // 得到顶层节点
    for(var i=0; i<rows.length; i++){
        var row = rows[i];
        if (!exists(rows, row.parentId)){
            nodes.push(row);
        }
    }

    var toDo = [];
    for(var i=0; i<nodes.length; i++){
        toDo.push(nodes[i]);
    }
    while(toDo.length){
        var node = toDo.shift();    // 父节点
        // 得到子节点
        for(var i=0; i<rows.length; i++){
            var row = rows[i];
            if (row.parentId == node.id){
                //注意这里子节点增加属性
                var child = row;
                if (node.children){
                    node.children.push(child);
                } else {
                    node.children = [child];
                }
                toDo.push(child);
            }
        }
    }
    return nodes;
}


/**
 * 列表数据转换为树形结构
 * @param rows 数据列表
 * @returns {Array}
 */
function treeConvert(rows){  
    function exists(rows, parentId){  
        for(var i=0; i<rows.length; i++){  
            if (rows[i].id == parentId) return true;  
        }  
        return false;  
    }  
      
    var nodes = [];  
    // 得到顶层节点
    for(var i=0; i<rows.length; i++){  
        var row = rows[i];  
        if (!exists(rows, row.parentId)){  
            nodes.push({//设置对应映射  
                id:row.id,  
                text:row.name,
                attributes:row,
                iconCls:row.iconCls
            });  
        }  
    }  
      
    var toDo = [];  
    for(var i=0; i<nodes.length; i++){  
        toDo.push(nodes[i]);  
    }  
    while(toDo.length){  
        var node = toDo.shift();    // 父节点 
        // 得到子节点 
        for(var i=0; i<rows.length; i++){  
            var row = rows[i];  
            if (row.parentId == node.id){ 
            	//注意这里子节点增加属性
                var child = {id:row.id,text:row.name,attributes:row,iconCls:row.iconCls};  
                if (node.children){  
                    node.children.push(child);  
                } else {  
                    node.children = [child];  
                }  
                toDo.push(child);  
            }  
        }  
    }  
    return nodes;  
}  

/**
 * 关闭窗口
 * @param el 关闭的对象
 */ 
function closeWin(el){
	$(el).window('close');
}

/**
 * 清空原有数据
 * @param el 元素ID
 */
function clearDataGrid(el){
    var item = $(el).datagrid('getRows');
    if (item) {
        for (var i = item.length - 1; i >= 0; i--) {
            var index = $(el).datagrid('getRowIndex', item[i]);
            $(el).datagrid('deleteRow', index);
        }
    }
    $(el).datagrid('loadData', { total: 0, rows: [] });
}

/**
 * form表单保存通用方法
 * @param formEl form表单对象
 * @param gridEl 数据列表对象
 * @param winEl  要关闭的窗口对象
 * @param requestUrl 请求路径
 */
function saveForm(formEl,gridEl,winEl,requestUrl) {  
	$(formEl).form('submit', {  
    	url: requestUrl,  
    	success:function(data){     
        	var json = $.parseJSON(data);  
        	if(json.success){  
            	closeWin($(winEl));  
            	//刷新数据  
            	$(gridEl).datagrid('reload'); 
        	}else{  
            	parent.$.messager.alert('温馨提示', json.message, 'info');  
        	}  
    	}    
	});  
}

/**
 * jq动态加载js
 * @param file
 */
function loadjs(file){ 
    var head = $('head').remove('#loadscript');
   $("<scri"+"pt>"+"</scr"+"ipt>").attr({src:ctx+file,type:'text/javascript',id:'load'}).appendto(head);
}