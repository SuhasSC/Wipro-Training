<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String user = (String) session.getAttribute("user");

if (user == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style>
body {
	font-family: Arial;
	text-align: center;
	margin-top: 100px;
}

a {
	text-decoration: none;
	border: 1px solid black;
	padding: 10px 20px;
}
</style>

</head>
<body>

	<h1>
		Welcome
		<%=user%></h1>

	<h3>Login Successful</h3>

	<br>

	<a href="logout">Logout</a>

</body>
</html>