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
	String name = request.getParameter("name"); 
	String email = request.getParameter("email"); 
	String password = request.getParameter("password"); 
	String about = request.getParameter("about"); 
	String favourite1 = request.getParameter("favourite1"); 
	String favourite2 = request.getParameter("favourite2"); 
	String fav = "";
			
	if (favourite1 != null) {
		fav += favourite1 + " - ";
	}
	
	if (favourite2 != null) {
		fav += favourite2 + " ";
	}
	%>
	<table style="border: none;">
		<tr>
			<td>Name</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=email%></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><%=password%></td>
		</tr>
		<tr>
			<td>About</td>
			<td><%=about%></td>
		</tr>
		<tr>
			<td>Favourites</td>
			<td><%=fav%></td>
		</tr>
		</tr>
	</table>
	
</body>
</html>