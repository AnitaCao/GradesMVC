<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@page session="false" %>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
   <title>Spring MVC</title>
  </head>

  <body>
    This is my Spring MVC!
    <a href="student/add.action">Add Student</a>  
	<a href="student/all.action">View Students List</a>  
    
    <h2>${msg}</h2>
  </body>
</html> --%>

<html>
<head>
	<title>Welcome Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h1>
	<a href="student/all.action">View Students List</a> 
</h1>

<br>
<h1>
	<a href="course/all.action">View Courses List</a> 
</h1>
<br>
<h1>
	<a href="teacher/all.action">View Teachers List</a> 
</h1>

</body>
</html>