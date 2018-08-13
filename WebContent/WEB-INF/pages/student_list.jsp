<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<html>
<head>
<title>Students List</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>

	<h3>Students List</h3>
	<c:if test="${!empty listStudents}">
		<table class="tg">
			<tr>
				<th width="80">Student ID</th>
				<th width="120">Student Name</th>
				<th width="120">Student Gender</th>
				<th width="120">Student DOB</th>
				<th width="120">Selected Course</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listStudents}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.sname}</td>
					<td>${student.ssex}</td>
					<td>${student.sdob}</td>
					<td>${student.coursesDisplay()}</td>
					<td><a href="<c:url value='/edit-${student.id}-student' />">Edit</a></td>
					<td><a href="<c:url value='/delete-${student.id}-student' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<a href="<c:url value='/student/new.action' />">Add New Student</a>
</body>
</html>