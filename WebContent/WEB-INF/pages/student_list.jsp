<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Student List</title>
</head>
<body>

   <!--  <form action="/studentlist.action" method="post"> -->
	<form>
        <table border="1">
            <tr>
                <td>id:</td>
                <td>Name:</td>
                <td>Gender:</td>
            </tr>

            <c:forEach items="${studentList}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.sname}</td>
                    <td>${p.ssex}</td>
                </tr>
            </c:forEach>

        </table>
    </form>

</body>
</html>