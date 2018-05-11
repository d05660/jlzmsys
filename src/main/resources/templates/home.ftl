<#import "spring.ftl" as spring/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jquery,ui,easy,easyui,web">
    <meta name="description" content="easyui help you build your web page easily!">
    <title>吉林智明社内管理システム</title>
    <link rel="shortcut icon" href="${contextPath}/assets/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/vender/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/superBlue.css" id="themeCss">
    <script type="text/javascript" src="${contextPath}/assets/vender/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/assets/vender/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${contextPath}/assets/vender/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
    <script type="text/javascript" src="${contextPath}/assets/js/extJs.js"></script>
    <script type="text/javascript" src="${contextPath}/assets/js/super.js"></script>
    <script type="text/javascript" src="${contextPath}/assets/js/custom.js"></script>
    <script type="text/javascript">
    	var basePath = "${contextPath }";
	</script>
</head>
<body id="main" class="easyui-layout">
<div data-options="region:'north',border:false" class="super-north">
    <!--顶部-->
    <#include "header.ftl">
</div>
<div data-options="region:'west',title:'导航菜单',border:false" class="super-west">
    <!--左侧导航-->
    <#include "menulist.ftl">
</div>
<div data-options="region:'center'" style="padding-top: 2px;">
    <!--主要内容-->
    <div id="tt" class="easyui-tabs" data-options="border:false,fit:true">
        <div title="首页" data-options="iconCls:'fa fa-home'">
            <div style="padding: 20px;">
                放点什么好呢......放点什么好呢......

                Language: <a href="?lang=zh_CN"><@spring.message "language.cn" /></a> - <a href="?lang=en_US"><@spring.message "language.en" /></a>
                <h2>
                    <spring:message code="welcome" />
                </h2>
                <@shiro.hasPermission name="/user/editPwdPage">
                   <a href="javascript:void(0)" onclick="editUserPwd()" class="easyui-linkbutton" plain="true" icon="fi-unlock" >修改密码</a>
                </@shiro.hasPermission>
            </div>
        </div>
    </div>
</div>
<div data-options="region:'south'" class="super-south">
    <!--页脚-->
    <div class="super-footer-info">
        <span><i class="fa fa-info-circle"></i> 吉林智明社内管理システム</span>
        <span><i class="fa fa-copyright"></i> CopyRight 2017 版权所有 <i class="fa fa-caret-right"></i></span>
    </div>
</div>
</body>
</html>