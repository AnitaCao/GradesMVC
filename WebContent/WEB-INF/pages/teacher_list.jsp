<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page session="false" %>
<html>
<head>
	<title>Teachers List</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h3>Teachers List</h3>
<c:if test="${!empty listTeachers}">
	<table class="tg">
	<tr>
		<th width="80">Teacher ID</th>
		<th width="120">Teacher Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTeachers}" var="teacher">
		<tr>
			<td>${teacher.id}</td>
			<td>${teacher.tname}</td>
			<td><a href="<c:url value='/edit-${teacher.id}-teacher' />" >Edit</a></td>
			<td><a href="<c:url value='/delete-${teacher.id}-teacher' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<br/>
    <a href="<c:url value='/teacher/new.action' />">Add New Teacher</a>
</body>
</html>