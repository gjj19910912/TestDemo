<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link href="extjs/resources/css/ext-all.css" rel="stylesheet" type="text/css" />
    <!-- <script src="extjs/ext-all.js" type="text/javascript"></script> -->
    
    <script type="text/javascript" src="extjs/adapter/ext/ext-base.js"></script> 
	<script type="text/javascript" src="extjs/ext-all.js"></script> 
	<script src="extjs/ext-lang-zh_CN.js" type="text/javascript"></script>
    <base href="<%=basePath%>">
    
    <title>test</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"  src="js/index.js"></script>
	
	<script type="text/javascript">
		function changeVlaue(){
			//form1.action = "/SpringFrameTest/changedo.do?message=hellpofjdslfs";
			form1.action = "/AndroidPushMessage_spring/pushControllerTest/sendInformationsTest?message=woshiceshishuju";
			form1.submit();
		}
	</script>
	
  </head>
  
  <body>
    <div id="grid">
    </div>
    
    <form action="" id="form1" method="post">
    	<button  id="btn" onclick="changeVlaue();"  style="width:100px;height:30px;"></button>
    </form>
  </body>
</html>
