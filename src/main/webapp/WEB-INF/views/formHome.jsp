<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Home</title>
</head>
<body>
	<h3>Form Home</h3>
	<form action ="/board/register">
		<input type="submit" value="register(GET)"/>
	</form>
	
	<form action ="/board/register" method ="POST">
		<input type="submit" value="register(POST)"/>
	</form>

	<form action ="/board/modify">
		<input type="submit" value="modify(GET)"/>
	</form>
	
	<form action ="/board/modify" method ="POST">
		<input type="submit" value="modify(POST)"/>
	</form>

	<form action ="/board/remove" method ="GET">
		<input type="submit" value="remove(GET)"/>
	</form>
	<form action ="/board/remove" method ="POST">
		<input type="submit" value="remove(POST)"/>
	</form>


</body>
</html>