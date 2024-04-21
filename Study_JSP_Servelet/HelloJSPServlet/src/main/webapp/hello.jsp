<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP!</h1>

	<% 
		int x = 10; 
		int y = 15;
		int sum = x + y;
	%>	
	<p> x = <%= x %></p>	
	
	<a href="user/profile.jsp?id=1&name=Văn Toàn">Profile User</a>
</body>
</html>