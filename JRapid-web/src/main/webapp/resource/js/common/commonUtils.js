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

/**
 * 字典JS工具类
 * @returns {{queryChildrenByCode: queryChildrenByCode}}
 */
var dictUtils = {
      /**
       * 根据父节点编码查询子节点
       * @param parentCode  父节点编码
       */
      queryChildrenByCode:function (parentCode) {
          var url = "/platform/sysDictionary/queryChildrenByCode/"+parentCode;
          jrapid_ajax_util.get(url,function (data) {
              dictData = data;
          });
          return dictData;
      }
};

/**
 * datagrid工具类
 * @type {{}}
 */
var dataGridUtils = {
    /**
     * 分页查询
     * @param object = {datagrid:数据列表对象,pagination:分页控件,queryData:查询条件,url:请求路径}
     */
    doPageQuery:function (object) {
        var datagrid = object.datagrid;
        var page = object.pagination;
        var url = object.url;
        datagrid.datagrid('loading');
        jrapid_ajax_util.post(url,object.queryData,function(data){
            if (data.status) {
                var total = data.page.totalRecord;
                var rows = data.page.results;
                var pageSize = data.page.pageSize;
                var pageNumber = data.page.pageNumber;
                if(rows != null){
                    if($.isArray(rows)){
                        datagrid.datagrid({data:rows});
                    }
                    else{
                        $.log("获取结果出错", rows);
                    }
                }

                $(page).pagination({
                    total: total,
                    pageSize: pageSize,
                    pageNumber: pageNumber,
                    onChangePageSize: function(pageSize){
                        object.queryData.page.pageSize = pageSize;
                        dataGridUtils.doPageQuery(pageNumber, pageSize);
                    },
                    onSelectPage: function(pageNumber, pageSize){
                        object.queryData.page.pageSize = pageSize;
                        object.queryData.page.pageNumber = pageNumber;
                        dataGridUtils.doPageQuery(pageNumber, pageSize);
                    }
                });

            } else {
                $.messager.alert('温馨提示', '加载数据失败！'+data.errorMsg, 'info');
            }
            datagrid.datagrid('loaded');
        });
    }
};