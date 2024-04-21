<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Hello World </h1>
	<%int id = Integer.valueOf(request.getParameter("id"));
	String name = request.getParameter("name");%>
	<p>Your id : <%=id%> </p>
	<p>Your name : <%=name%> </p>
	<a href="logout.jsp">Logout</a>
</body>
</html>