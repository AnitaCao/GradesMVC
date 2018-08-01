<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Grades List</title>
</head>
<body>

    <form>

        <table border="1">
            <tr>
                <td>id:</td>
                
            </tr>

            <c:forEach items="${gradesList}" var="g">
                <tr>
                    <td>${g.toString()}</td>
                   
                </tr>
            </c:forEach>

        </table>
    </form>

</body>
</html>