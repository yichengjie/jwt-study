<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script type ="text/javascript" src ="${request.contextPath}/public/jquery.js" ></script>
    <script type ="text/javascript" src ="${request.contextPath}/js/common.js" ></script>
</head>
<body>
	<input type="hidden" id ="contextPath" vlaue ="${request.contextPath}" />
	<form>
		用户名：<input type ="text" id ="username"  /><br/>
		密&nbsp;&nbsp;&nbsp;码：<input type ="text" id = "password" /></br/>
		<button type ="button" id ="loginBtn">登录</button>	
	</form>
	
	<script type ="text/javascript" src ="${request.contextPath}/js/login.js"></script>
</body>
</html>