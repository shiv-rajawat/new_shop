<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Hello people! Welcome to Mera Mart </h1>

<h4>Please provide your credentials to view products</h4>

<form action="UserServlet" method="post">
Username  <input type="text" name="userName" required/><br><br>
Password  <input type="password" name="password" required/><br><br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="submit" name="doLogin" value="Login"><br><br>
<h4 style="color:red;">${message}</h4><br>

<a href="${pageContext.request.contextPath}/Register.jsp" ><h4 style="color:blue;">New to Mera Mart? Register here!!</h4></a>
</form>

</body>
</html>