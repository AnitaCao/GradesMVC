<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>
<body>

	<form:form method="POST" modelAttribute="course">
		<form:input type="hidden" path="id" id="id" />
		<table>

			<tr>
				<td><label for="code">Course Code: </label></td>
				<td><form:input path="code" id="code" /></td>
				<td><form:errors path="code" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="title">Course Title: </label></td>
				<td><form:input path="title" id="title" /></td>
				<td><form:errors path="title" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="content">Content: </label></td>
				<td><form:input path="content" id="content" /></td>
				<td><form:errors path="content" cssClass="error" /></td>
			</tr>

			<%-- <tr>
				<td><label for="teacher">Teacher: </label></td>
				<td><form:input path="teacher" id="teacher" /></td>
				<td><form:errors path="teacher" cssClass="error" /></td>
			</tr> --%>

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
	<a href="<c:url value='/course/all.action' />">List of All Courses</a>
</body>
</html>
