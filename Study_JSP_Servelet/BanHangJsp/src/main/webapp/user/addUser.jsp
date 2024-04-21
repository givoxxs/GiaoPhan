<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add new user!</h1>
	<form action="viewUser.jsp" method="post">
		<label for="name">Name:</label> 
		<input type="text" id="name" name="name" required><br>
		<br> 
		<label for="email">Email:</label> 
		<input type="email" id="email" name="email" required><br>
		<br> 
		<label for="phone">Phone:</label>
		<input type="tel" id="phone" name="phone" required><br>
		<br>
		<label for="username">Username:</label>
		<input type="text" id="username" name="username" required><br>
		<br>
		<label for="password">Password:</label> 
		<input type="password" id="password" name="password" required><br>
		<br> 
		<label for="role">Role:</label> 
		<select name="role" id="role">
			<option value="admin">Admin</option>
			<option value="user">User</option>
		</select>
		<textarea name="about" rows="3" cols="20" placeholder="About you?"></textarea>
		<br>
		<input type="checkbox" id="favourites" name="favourite1"
		value="Watch movie">Watch Movie
		<br>
		<input type="checkbox" id="favourites" name="favourite2"
		value="Play music">Play Music
		<br>

		<input type="submit" value="Add new user">
	</form>
</body>
</html>