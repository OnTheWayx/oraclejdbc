<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	background-color: cornflowerblue;
	width: 180px;
	height: 240px;
	position: absolute;
	left: 750px;
	top: 160px;
	border: solid black 2px;
	border-left: none;
	padding: 20px;
}

div {
	background-color: cornflowerblue;
	width: 120px;
	height: 240px;
	position: absolute;
	left: 590px;
	top: 160px;
	border: solid black 2px;
	border-right: none;
	padding: 20px;
}

.register {
	position: relative;
	top: 10px;
}

a {
	display: block;
	height: 8px;
}

input {
	height: 22px;
}
body {
	background-color: floralwhite;
}
</style>
</head>
<body>
	<form action="DoRegister" method="post">
		<input type="text" name="username"><br> <input type="tel"
			name="tel"><br> <input type="number" name="age"><br>
		<input type="email" name="email"><br> <input type="text"
			name="address"><br> 是<input type="radio" name="yesorno" value="是"
			checked="checked"> 否<input type="radio" name="yesorno" value="否"
			checked="checked"><br> <input type="password"
			name="password"><br> <input type="date" name="birth"><br>
		<input type="submit" value="注册" class="register"><br>
	</form>
	<div>
		<a>用户名：</a><br> <a>电话：</a><br> <a>年龄：</a><br> <a>邮箱：</a><br>
		<a>地址：</a><br> <a>是否为管理员：</a><br> <a>密码：</a><br> <a>生日：</a><br>
	</div>
</body>
</html>