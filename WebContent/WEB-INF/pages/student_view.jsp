<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<h3>New Student Details</h3>
	<form:form method="POST" action="/GradesMVC/student/updateStudentList.action"
		modelAttribute="student">
		<table>
			<tr>
				<td>Name :</td>
				<td>${sname}</td>
			</tr>
			<tr>
				<td>ID :</td>
				<td>${id}</td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td>${ssex}</td>
			</tr>
			<tr>
				<td>Date of Birth :</td>
				<td>${sdob}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Cancel" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
