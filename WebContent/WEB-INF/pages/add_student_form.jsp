<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Student Details</h3>
        <form:form method="POST"
          action="/GradesMVC/student/confirmAddStudent.action" modelAttribute="student">
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
