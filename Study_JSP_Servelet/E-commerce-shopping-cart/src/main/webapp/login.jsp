<%@page import="me.hitoan.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
		User auth = (User) request.getSession().getAttribute("auth");
		if (auth != null) {
			response.sendRedirect("index.jsp");
		}
		
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
		if (cart_list != null) {
			request.setAttribute("cart_list", cart_list);
		}
	%>
<!DOCTYPE html>
<html>
<head>
<title>LOGIN</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp" %>
	<div class="container">
		<div class="card w-50 mx-auto mt-5">
			<div class="card-header text-center">
				<h2>Login</h2>
			</div>
			<div class="card-body">
				<form action="user-login" method="post">
					<div class="form-group">
						<label for="email">Email Address:</label> 
						<input type="email" class="form-control" id="email" name="login-email" 
							placeholder="Enter your email" required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> 
						<input type="password" class="form-control" id="password" name="login-password" 
							placeholder="********" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>	
		</div>
	</div>
</body>
<%@include file="includes/footer.jsp"%>
</html>