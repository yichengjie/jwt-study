<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script type ="text/javascript" src ="${request.contextPath}/public/jquery.js" ></script>
    <script type ="text/javascript" src ="${request.contextPath}/js/common.js" ></script>
</head>
<body>

	<input type="hidden" id ="contextPath" vlaue ="${request.contextPath}" />
	<a id ="req1" href ="#">ajax请求资源【getMessage】，携带token</a><br/>
	<a  href ="${request.contextPath}/api/getMessage">超链接请求资源【getMessage】</a><br/>
	<a href ="${request.contextPath}/login">用户登录</a>
	<script type ="text/javascript" src ="${request.contextPath}/js/index.js" ></script>
</body>
</html>