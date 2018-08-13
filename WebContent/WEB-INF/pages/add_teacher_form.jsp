<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>
<body>

	<form:form method="POST" modelAttribute="teacher">
		<form:input type="hidden" path="id" id="id" />
		<table>

			<tr>
				<td><label for="tname">Teacher Name: </label></td>
				<td><form:input path="tname" id="tname" /></td>
				<td><form:errors path="tname" cssClass="error" /></td>
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
	<a href="<c:url value='/teacher/all.action' />">List of All Teachers</a>
</body>
</html>
