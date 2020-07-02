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

			<th>Name</th>
			<th>Password</th>

			<c:forEach var="student" items="${studentList}">
				<tr>

					<td>${student.name}</td>
					<td>${student.password}</td>
					<td><a href="editStudent?id=${student.id}">Edit</a> <a
						href="deleteStudent?id=${student.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>