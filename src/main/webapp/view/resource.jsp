<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String _path = request.getContextPath();
String _basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+_path;

%>
<!-- 公共资源CSS,JS  -->
<!--Css -->
<link rel="stylesheet"  href="<%=_basePath %>/easyui/themes/default/easyui.css" type="text/css">
<link rel="stylesheet" href="<%=_basePath %>/easyui/themes/icon.css" type="text/css"></link>

<link rel="stylesheet" type="text/css" href="<%=_basePath %>/css/base.css">
<!-- ** Javascript ** -->
<script type="text/javascript" src="<%=_basePath %>/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=_basePath %>/easyui/jquery.form.js"></script>
<script type="text/javascript" src="<%=_basePath %>/easyui/package.js"></script>
<script type="text/javascript" src="<%=_basePath %>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=_basePath %>/js/commons/urls.js?v=11"></script>
<script type="text/javascript" src="<%=_basePath %>/js/commons/base.js?v=11"></script>
<script type="text/javascript" src="<%=_basePath %>/js/commons/voole_common.js?v=11"></script>


<script type="text/javascript">
   /*全局变量 路径*/
   var webPath = "<%=_basePath %>";
   /*菜单路径 勿动*/
   var menuUrl =window.location.href;
   <%-- var _globleUserName = "<%=session.getAttribute("username") %>";
   var _globleUserType = "<%=session.getAttribute("userType") %>";
   var _globleUserId= "<%=session.getAttribute("userId") %>"; --%>
</script>