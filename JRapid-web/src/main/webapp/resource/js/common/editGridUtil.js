/**
 * Created by fwj on 2016/12/2.
 */
var editGridUtil = function () {
    var editIndex = undefined;
    var editGrid = undefined;
    return {

        initEditGrid:function (widgetId) {
            editGrid = $(widgetId);
        },

        /**
         * 结束编辑
         * @returns {boolean}
         */
        endEditing:function () {
            if (editIndex == undefined){return true}
            if (editGrid.datagrid('validateRow', editIndex)){
                editGrid.datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
            }
        },

        /**
         * 点击单元格
         * @param index 行序号
         * @param field 单元格名称
         */
        onClickCell:function (index, field) {
            if (editIndex != index){
                if (this.endEditing()){
                    editGrid.datagrid('selectRow', index)
                        .datagrid('beginEdit', index);
                    var ed = editGrid.datagrid('getEditor', {index:index,field:field});
                    if (ed){
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    setTimeout(function(){
                        editGrid.datagrid('selectRow', editIndex);
                    },0);
                }
            }
        },

        /**
         * 编辑结束事件
         * @param index 行序号
         * @param row   编辑行
         */
        onEndEdit:function (index, row) {
            /*var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'productid'
            });
            row.productname = $(ed.target).combobox('getText');*/
        },

        /**
         * 添加行
         * @param rowData 行数据
         */
        addRow:function (rowData) {
            if (this.endEditing()){
                editGrid.datagrid('appendRow',rowData);
                editIndex = editGrid.datagrid('getRows').length-1;
                editGrid.datagrid('selectRow', editIndex).datagrid('beginEdit', editIndex);
            }
        },

        /**
         * 删除行
         */
        removeit:function(){
            if (editIndex == undefined){return}
            editGrid.datagrid('cancelEdit', editIndex).datagrid('deleteRow', editIndex);
            editIndex = undefined;
        }
    }
};