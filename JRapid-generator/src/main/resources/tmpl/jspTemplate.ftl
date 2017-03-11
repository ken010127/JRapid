<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file="/view/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="/view/common/meta.jsp"%>
    <%@ include file="/view/common/admin_head.jsp"%>

    <title>${title}</title>
    <script type="text/javascript" src="<%=ctx %>/resource/js/content/${modulePackage}/${className}_init.js"></script>
    <script type="text/javascript" src="<%=ctx %>/resource/js/content/${modulePackage}/${className}_operate.js"></script>
</head>
<body>
    <div name="jrapid_main" class="easyui-layout" data-options="fit:true">
        <div name="jrapid_head" class="easyui-panel jrapid_head" style="width: 100%" data-options="region:'north',border:false">
            <div name="jrapid_title" class="jrapid_title">
                <font class="jrapid_title_name">查询条件</font>
            </div>
            <div name="jrapid_query_condition" class="jrapid_query_condition">
                <form id="query_form" class="query_form">
                    <div name="jrapid_form_container" class="jrapid_form_container">
                        <ul><#list tableConfigs as config><#if config.isSearch=="Y">
                            <li>
                                <label class="title">${config.title}:</label>
                                <input class="${config.searchType}" id="query_${config.field}" name="${config.property}"/>
                            </li></#if></#list>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
        <div name="jrapid_content" class="jrapid_content" style="width: 100%" data-options="region:'center',border:false">
            <div name="jrapid_title" class="jrapid_title">
                <font class="jrapid_title_name">${title}列表</font>
            </div>
            <div name="jrapid_datagrid_panel">
                <table id="jrapid_datagrid"></table>
            </div>
        </div>
    </div>

    <!--编辑窗口-->
    <div id="modify_Win" class="easyui-window" title="${title}编辑页面" closed="true"
         modal="true" style="padding: 10px;width: auto;"  closed="true"
         maximizable="true" minimizable="true" collapsible="false" fit="true">
        <div style="padding:10px 10px">
            <form id="modify_Form" method="post">
                <!--隐藏字段--><#list tableConfigs as config><#if config.isModify=="N">
                <input type="hidden" id="modify_${config.field}" name="${config.field}"/></#if></#list>

                <table>
                    <tr><#list tableConfigs as config><#if config.isModify=="Y">
                        <td>${config.title}:</td>
                        <td><input class="${config.modifyType}" type="text" name="${config.field}" <#if config.allowNull=="Y">data-options="required:true"</#if>/></td>
                    </tr></#if></#list>
                </table>
            </form>
            <div style="text-align:center;padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重设</a>
            </div>
        </div>
    </div>

</body>
</html>