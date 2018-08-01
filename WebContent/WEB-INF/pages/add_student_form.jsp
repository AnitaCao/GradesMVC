<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Student Details</h3>
        <form:form method="POST"
          action="/GradesMVC/addStudent.action" modelAttribute="student">
             <table>
                <tr>
                    <td><form:label path="sname">Name</form:label></td>
                    <td><form:input path="sname"/></td>
                </tr>
                <tr>
                    <td><form:label path="ssex">Gender (m/f)</form:label></td>
                    <td><form:input path="ssex"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="sdob" type="date">
                      Date of Birth (yyyy-MM-dd)</form:label></td>
                    <td><form:input path="sdob"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
