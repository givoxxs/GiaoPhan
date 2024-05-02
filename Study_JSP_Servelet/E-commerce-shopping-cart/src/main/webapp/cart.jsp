<%@page import="me.hitoan.connection.DbCon"%>
<%@page import="me.hitoan.model.*"%>
<%@page import="java.util.*"%>
<%@page import="me.hitoan.dao.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct = pDao.getCardProducts(cart_list);
	double total_price = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total_price", total_price);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Cart Page</title>
<%@include file="includes/header.jsp"%>
<style type="text/css">
.table tbody td {
	vartical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: $ ${(total_price > 0)?dcf.format(total_price):0}</h3>
			<a class="mx-3 btn btn-primary" href="#">Check Out</a>
		</div>
		<table class="table table-loght">
			<thread>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Price</th>
				<th scope="col">Buy Now</th>
				<th scope="col">Cancel</th>
			</tr>
			</thread>
			<tbody>
			<% 
			if(cart_list != null) {
                for(Cart c:cartProduct) {%>
                	<tr>
					<td><%= c.getName() %></td>
					<td><%= c.getCategory() %></td>
					<td><%= dcf.format(c.getPrice()) %>$</td>
					<td>
						<form action="order-now" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
							<div class="form-group d-flex justify-content-between w-50">
								<a href="quantity-inc-dec?action=dec&id=<%= c.getId() %>" class="btn btn-sm btn-decre"><i class="fas fa-minus-square"></i></a> 
								
								<input type="text" name="quantity" value="<%= c.getQuantity() %>" class="form-control w-50" readonly>
								
								<a href="quantity-inc-dec?action=inc&id=<%= c.getId() %>" class="btn btn-sm btn-incre"><i class="fas fa-plus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-sm btn-success">Buy</button>	
						</form>
					</td>
					<td><a href="remove-from-cart?id=<%= c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>
                <%}
             }
			%>
				
			</tbody>
		</table>
	</div>
</body>
<%@include file="includes/footer.jsp"%>
</html>