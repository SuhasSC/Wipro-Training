<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
body {
	font-family: Arial;
	text-align: center;
	margin-top: 100px;
}

form {
	border: 1px solid black;
	display: inline-block;
	padding: 20px;
}

input {
	margin: 10px;
	padding: 8px;
	width: 200px;
}

button {
	padding: 8px 20px;
}
</style>

</head>
<body>

	<h2>Login Form</h2>

	<form action="login" method="post">

		<input type="text" name="username" placeholder="Enter Username"
			required> <br> <input type="password" name="password"
			placeholder="Enter Password" required> <br>

		<button type="submit">Login</button>

	</form>

</body>
</html>