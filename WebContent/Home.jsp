
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.apnacart.model.pojo.ProductPojo"%>
<%@page import="com.apnacart.model.service.ProductService"%>
<%@page import="java.util.ArrayList"%>
 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body> 

	<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String userName = (String) session.getAttribute("user");
				out.print("Welcome, " + userName + "  We are pleased to have you here.");
			} else {
				response.sendRedirect("Login.jsp");
			}
		}
	%>


	<h1 style= color:blue>HACKED</h1>
	<h2 style= color:blue>Under Construction</h2><br>
	<h3 style= color:blue>Beware of Dogs!!</h3>
	<br><br>
	
	
	<c:forEach items="${productsList}" var="product">
	<form action="ProductServlet" method="post">
    <div class="w3-display-container w3-hover-opacity">
    	
        <div class="w3-display-topleft w3-display-hover w3-xlarge">
         <p> <b> ${product.productId}   ${product.productName}</b></p>
            <h5 class="w3-display-bottom">${product.price}</h5>
            <input type = "hidden" value="${product.productId}" name="id" />
            <input type = "hidden" value="${product.productName}" name="name" />
            <input type = "hidden" value="${product.price}" name="price" />
            Enter quantity <input type="number" name = "quantity"/>
            <input type="submit" value="Add to Cart" name="addToCart">
            <input type="button"  value = "Buy Now"<c:if test="${product.quantity < 0}"><c:out value="disabled='disabled'"/></c:if>>
            <br><br><br><br><br>
           
            
        </div>
    </div>
    </form>
</c:forEach>

	
	<br><br>
	<form action="UserServlet" method="post">
			<input type="submit" name="doLogout" value="Logout">
	</form>
</body>
</html>