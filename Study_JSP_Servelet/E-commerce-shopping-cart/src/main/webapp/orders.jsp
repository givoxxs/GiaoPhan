<%@page import="me.hitoan.connection.DbCon"%>
<%@page import="me.hitoan.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
		User auth = (User) request.getSession().getAttribute("auth");
		if (auth != null) {
			request.setAttribute("auth", auth);
		}
		
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		if (cart_list != null) {
			request.setAttribute("cart_list", cart_list);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<title>Orders Page</title>
<%@include file="includes/header.jsp"%>
</head>
<body>	
	<%@include file="includes/navbar.jsp" %>
</body>
<%@include file="includes/footer.jsp"%>
</html>