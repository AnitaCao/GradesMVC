<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>
<body>

	<form:form method="POST" modelAttribute="student">
		<form:input type="hidden" path="id" id="id" />
		<table>

			<tr>
				<td><label for="sname">Student Name: </label></td>
				<td><form:input path="sname" id="sname" /></td>
				<td><form:errors path="sname" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="ssex">Gender: </label></td>
				<td><form:input path="ssex" id="ssex" /></td>
				<td><form:errors path="ssex" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="sdob">DOB: </label></td>
				<td><form:input path="sdob" id="sdob" /></td>
				<td><form:errors path="sdob" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/student/all.action' />">List of All Students</a>
</body>
</html>

