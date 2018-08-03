<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Hi there! Welcome to the Mera Mart family. We are glad to have you here. </h2>
<form action="UserServlet" method="post">
Choose a username &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input type="text" name="username" required/><br><br>
Choose a Password  <input type="password" name="password" required/><br><br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="submit" name="doRegister" value="Register"><br><br>
</form>
</body>
</html>