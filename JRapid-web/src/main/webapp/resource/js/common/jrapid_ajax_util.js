/**
 * ajax请求工具类
 * Created by FWJ on 2016/11/22.
 */
if (!window.ajax) {
    window.jrapid_ajax_util={};
}

/**
 * 基础ajax post请求方法
 * @param type 请求类型
 * @param url 地址
 * @param requestData 请求数据
 * @param callback 回调函数
 */
jrapid_ajax_util.basePostAjax=function (type,url,requestData,callback) {
    $.ajax({
        url : ctx+url,
        type : type,
        contentType:"application/json",
        data : JSON.stringify(requestData),
        async : false,
        success: function(data) {
            callback(data);
        },
        error:function (jqXHR, textStatus, errorThrown) {
            $.messager.alert('错误提示', jqXHR.status + ' ' + jqXHR.responseText, 'info');
        }
    });
};

jrapid_ajax_util.baseGetAjax=function (type,url,callback) {
    $.ajax({
        url : ctx+url,
        type : type,
        contentType:"application/json",
        async : false,
        success: callback,
        error:function (jqXHR, textStatus, errorThrown) {
            $.messager.alert('错误提示', jqXHR.status + ' ' + jqXHR.responseText, 'info');
        }
    });
};

//post请求
jrapid_ajax_util.post=function (url, requestData, callback) {
    jrapid_ajax_util.basePostAjax('POST',url,requestData,callback);
};

//get请求
jrapid_ajax_util.get=function (url, callback) {
    jrapid_ajax_util.baseGetAjax('GET',url,callback);
};

//put请求
jrapid_ajax_util.put=function (url, requestData, callback) {
    jrapid_ajax_util.basePostAjax('PUT',url,requestData,callback);
};

jrapid_ajax_util.delete=function (url, callback) {
    jrapid_ajax_util.baseGetAjax('DELETE',url,callback);
};

// jrapid_ajax_util.asyncGet=function (pUrl,pParam,callback,pNoMaskFlag) {
//     var vData;
//     $.ajax({
//         url : pUrl,
//         type : 'GET',
//         contentType:"application/json",
//         data : JSON.stringify(pParam),
//         beforeSend:function(){
//             if (!pNoMaskFlag||pNoMaskFlag==false) {
//                 eventPlugin.submitLoading();
//             }
//         },
//         success : function(data) {
//             if (data&&(data.status=='true'||data.status==true)) {
//                 vData=data.content;
//             } else {
//                 jrapid_ajax_util.handleException(data);
//                 vData = false;
//             }
//
//         },
//         complete:function(){
//             if(callback){
//                 callback(vData);
//             }
//             if (!pNoMaskFlag||pNoMaskFlag==false) {
//                 eventPlugin.submitLoaded();
//             }
//         }
//     });
//     return vData;
// }
//
// //mod by czg 20160818 如果pNoMaskFlag的值为空或者为false则弹出全屏的遮罩
// jrapid_ajax_util.asyncPost=function (pUrl,pParam,callback,pNoMaskFlag) {
//     var vData;
//     var _resData;  //增加数据参数返回所有获取的data数据(工单组需求);
//     $.ajax({
//         url : pUrl,
//         type : 'POST',
//         contentType:"application/json",
//         data : JSON.stringify(pParam),
//         beforeSend:function(){
//             if (!pNoMaskFlag||pNoMaskFlag==false) {
//                 //显示遮罩
//                 eventPlugin.submitLoading();
//             }
//         },
//         //async : false,
//         success: function(data) {
//             if (data && (data.status == 'true' || data.status == true)) {
//                 _resData=data;
//                 vData = data.content;
//             } else {
//                 jrapid_ajax_util.handleException(data);
//                 vData = false;
//                 _resData=false;
//             }
//         },
//         complete:function(){
//             if(callback){
//                 callback(vData,_resData);
//             }
//             if (!pNoMaskFlag||pNoMaskFlag==false) {
//                 //影藏遮罩
//                 eventPlugin.submitLoaded();
//             }
//         }
//     });
//     return vData;
// }
//
//
// jrapid_ajax_util.del=function (pUrl,pParam) {
//     var vData;
//     $.ajax({
//         url : pUrl,
//         type : 'DELETE',
//         contentType:"application/json",
//         data : JSON.stringify(pParam),
//         async : false,
//         success : function(data) {
//             if (data&&(data.status=='true'||data.status==true)) {
//                 vData=data.content;
//             } else {
//                 jrapid_ajax_util.handleException(data);
//                 vData = false;
//                 //return false;
//             }
//         }
//     });
//     return vData;
// }
// jrapid_ajax_util.postParam=function (pUrl,pParam) {
//     var vData;
//     $.ajax({
//         url: pUrl,
//         type: 'POST',
//         data: pParam,
//         async: false,
//         dataType: 'json',
//         success : function(data) {
//             if (data&&(data.status=='true'||data.status==true)) {
//                 vData=data.content;
//             } else {
//                 jrapid_ajax_util.handleException(data);
//                 vData = false;
//                 //return false;
//             }
//         },
//         error:function(data){
//             jrapid_ajax_util.handleException(data);
//             vData = false;
//             //return false;
//         }
//     });
//     return vData;
// }
//
// //异步postParam方法
// jrapid_ajax_util.asyncPostParam=function (pUrl,pParam,callback,pNoMaskFlag) {
//     var vData;
//     $.ajax({
//         url: pUrl,
//         type: 'POST',
//         data: pParam,
//         dataType: 'json',
//         beforeSend:function(){
//             if (!pNoMaskFlag||pNoMaskFlag==false) {
//                 //显示遮罩
//                 eventPlugin.submitLoading();
//             }
//         },
//         success : function(data) {
//             if (data&&(data.status=='true'||data.status==true)) {
//                 vData=data.content;
//             } else {
//                 jrapid_ajax_util.handleException(data);
//                 vData = false;
//             }
//         },
//         complete:function(){
//             if(callback){
//                 callback(vData);
//             }
//             if (!pNoMaskFlag||pNoMaskFlag==false) {
//                 //影藏遮罩
//                 eventPlugin.submitLoaded();
//             }
//         },
//         error:function(data){
//             jrapid_ajax_util.handleException(data);
//             vData = false;
//         }
//     });
//     return vData;
// }
//
//
// jrapid_ajax_util.data=function (pUrl,pParam,pAsync,pSuccess) {
//     var vData;
//     $.ajax({
//         url: pUrl,
//         type: 'POST',
//         data: pParam,
//         dataType: 'json',
//         async: typeof(pAsync)=="boolean"?pAsync:false,
//         success : function(data) {
//             if (data&&(data.status=='true'||data.status==true)) {
//                 vData=data.content;
//                 if(pSuccess){
//                     //异步回调
//                     pSuccess(vData);
//                 }
//             } else {
//                 jrapid_ajax_util.handleException(data);
//                 return false;
//             }
//         },
//         error:function(data){
//             jrapid_ajax_util.handleException(data);
//             return false;
//         }
//     });
//     return vData;
// }
//
// /** 异常处理 **/
// /** 输出参数格式 后端枚举方式存储全局错误信息，前端提示用户时候可以适当调整输出界面内容
//  * pData.errCode 错误码
//  * pData.errMsg  错误信息
//  * pData.content json内容
//  *  **/
// jrapid_ajax_util.handleException = function (pData) {
//     if (!pData) {
//         midea_msg_lib.error("出错提示","系统发生未知异常！");
//     }
//     if(JSON.stringify(pData).indexOf("<script>")>0){
//         window.location.reload();//刷新当前页面.
//         return;
//     }
//     var isJsonObject = typeof(pData) == "object" && Object.prototype.toString.call(pData).toLowerCase() == "[object object]" && !pData.length;
//     if (!isJsonObject) {
//         pData = JSON.parse(pData);
//     }
//     if (!pData||!pData.error) {
//         midea_msg_lib.error("出错提示","调用失败，远程服务无响应！");
//         return;
//     }
//
//     var vError=pData.error;
//     if (vError.errorCode=="error_not_login") {
//         midea_msg_lib.error("出错提示","登录...未完成...此处弹出登录框...");
//     } else if (vError.errorCode=="error_no_priv") {
//         midea_msg_lib.error("出错提示","你没有此操作权限！");
//     } else if(vError.errorCode=="SYS_ERROR_CONFIG") {
//         var div = "<div id='errorMsg' style='display: none;word-wrap: break-word;width:255px;height:200px'>" + vError.errMsg + "</div>"
//         midea_msg_lib.error("出错提示","系统发生非自定义异常。<a href='###' onclick='jrapid_ajax_util.sysError()'>查看详细信息</a>" + div);
//     }  else if(vError.errorCode=="SYS_RPC_TIMEOUT") {
//         var div = "<div id='errorMsg' style='display: none;word-wrap: break-word;width:255px;height:200px'>" + vError.errMsg + "</div>"
//         midea_msg_lib.error("出错提示","系统调用超时。<a href='###' onclick='jrapid_ajax_util.sysError()'>查看详细信息</a>" + div);
//     } else if (vError.errMsg){
//         midea_msg_lib.error("出错提示",vError.errMsg);
//     } else {
//         midea_msg_lib.error("出错提示","操作失败，服务端发生未知异常！");
//     }
//
//     return ;
// }
// jrapid_ajax_util.sysError= function (){
//     if ($("#errorMsg").css("display") == "none") {
//         $("#errorMsg").show();
//     } else {
//         $("#errorMsg").hide();
//     }
// }