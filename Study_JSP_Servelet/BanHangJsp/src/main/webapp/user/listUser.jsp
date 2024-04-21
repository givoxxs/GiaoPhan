<%@page import="hitoan.me.service.UserService"%>
<%@page import="hitoan.me.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List all Users</h1>
	<%	
		UserService userService = new UserService();
		List<User> users = userService.getAllUsers();
	%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Fullname</th>
			<th>Choice</th>
		</tr>
		<%	
		    for (User user : users) {
		%>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getName()%></td>
			<td><a href="editUser.jsp?id=<%=user.getId()%>">Edit</a> | 
				<a href="deleteUser.jsp?id=<%=user.getId()%>">Delete</a></td>
		</tr>
		<%
		    }
		%>
		
	</table>
</body>
</html>