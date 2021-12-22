<%@page import="org.apache.jasper.JasperException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.sql.*,test.*,po.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: solid black 2px;
	width: 830px;
	height: 360px;
	margin: auto;
}

td {
	text-align: center;
}

body {
	background-color: floralwhite;
}

div {
	position: absolute;
	top: 89px;
	left: 320px;
}

.delete {
	color: blue;
}

.delete:hover {
	color: cornflowerblue;
	cursor: pointer;
}

.update {
	color: blue;
}

.update:hover {
	color: cornflowerblue;
	cursor: pointer;
}
</style>
</head>
<body>

	<%
	try {
		if (!session.getAttribute("login").equals("success") && !session.getAttribute("register").equals("success")
		&& !session.getAttribute("delete").equals("success")) {
			response.sendRedirect("login.jsp");
		}
		if (session.getAttribute("login").equals("success")) {
	%>
	<script type="text/javascript">
		alert("登录成功");
	</script>
	<%
	session.setAttribute("login", "false");
	}
	if (session.getAttribute("register").equals("success")) {
	%>
	<script type="text/javascript">
		alert("注册成功");
	</script>
	<%
	session.setAttribute("register", "false");
	}
	session.setAttribute("delete", "false");
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
	<%
	List<User> users = MainTest.selectAll();
	request.setAttribute("users", users);
	int count = users.size();
	%>
	<hr>
	<br>
	<br>
	<table>
		<tr style="background-color: rgb(219, 241, 212);">
			<td>名字</td>
			<td>电话</td>
			<td>年龄</td>
			<td>邮箱</td>
			<td>地址</td>
			<td>是否是管理员</td>
			<td>密码</td>
			<td>生日</td>
			<td>数据删除</td>
			<td>数据修改</td>
		</tr>
		<c:forEach var="user" items="${requestScope.users }"
			varStatus="status">
			<tr
				<c:if test="${status.index % 2 == 1 }">style="background-color:rgb(219,241,212);" </c:if>>
				<td>${user.getUname() }</td>
				<td>${user.getTel() }</td>
				<td>${user.getAge() }</td>
				<td>${user.getEmail() }</td>
				<td>${user.getAddress() }</td>
				<td>${user.getYesorno() }</td>
				<td>${user.getPassword() }</td>
				<td>${user.getBirth() }</td>
				<td><a href="DoDelete?id=${user.getUname()}" class="delete">删除</a></td>
				<td><a href="UpdateUser?${user.getUname()}" class="update">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<hr>
	<a href="login.jsp">退出登录</a>
</body>
</html>