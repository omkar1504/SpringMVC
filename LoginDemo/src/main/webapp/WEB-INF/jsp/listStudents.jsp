<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Student List</h1>
		<table border="1">

			<th>Id</th>
			<th>Name</th>
			<th>Password</th>

			<c:forEach var="student" items="${studentList}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.password}</td>
					<td><a href="getById?id=${student.id}">Edit</a> <a
						href="deleteStudent?id=${student.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

<!-- <form>
		ID : <input type="text" name="id" value="{studentInfo}"> </br>
		Name : <input type="text" name="name" value="{student.name}"></br>
		Password : <input type="password" name="password"
			value="{student.password}"></br> <input type="submit"
			value="REGISTER">
	</form> -->