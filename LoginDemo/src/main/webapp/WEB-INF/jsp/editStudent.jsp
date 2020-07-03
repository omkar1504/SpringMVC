<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>EDIT FORM</h1>
	<form action="updateStudent" method="post">
		ID : <input type="text" name="id" value="${student.id}"
			readonly="readonly"></br> Name : <input type="text" name="name"
			value="${student.name}"></br> Password : <input type="text"
			name="password" value="${student.password}"></br>
			<input type="submit" value="UPDATE"></br>
			${done} </br>
			<a href="get">Show All Students</a>
	</form>
</body>
</html>