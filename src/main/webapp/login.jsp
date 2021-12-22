<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
form{
				background-color: cornflowerblue;
				width: 180px;
				height: 100px;
				position: absolute;
				left: 750px;
				top: 160px;
				border: solid black 2px;
				border-left: none;
				padding-top: 20px;
				padding-left: 20px;
				padding-right: 20px;
			}
			div{
				background-color: cornflowerblue;
				width: 120px;
				height:	100px;
				position: absolute;
				left: 590px;
				top: 160px;
				border: solid black 2px;
				border-right: none;
				padding-top: 20px;
				padding-left: 20px;
				padding-right: 20px;
			}
			.register{
				position: relative;
				top:10px;
			}
			a{
				display: block;
				height: 5px;
			}
			input{
				height: 20px;
			}
			
			body{
				background-color: floralwhite;
				}
			.submit{
				height: 22px;
				position: relative;
				bottom: 0px;
			}
</style>
</head>
<body>
<form action="DoLogin" method="post">
<input type="text" name="username"><br>
<input type="password" name="password"><br>
<input type="submit" value="登录" class="submit">
<a href="register.jsp">注册用户</a>
</form>
<div>
			<a>用户名：</a><br>
			<a>密码：</a><br>
		</div>
</body>
</html>