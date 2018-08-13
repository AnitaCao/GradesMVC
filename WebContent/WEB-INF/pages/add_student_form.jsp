<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 
    <div class="generic-container">
    <div class="well lead">Student Registration Form</div>
    <form:form method="POST" modelAttribute="student" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="first_name" id="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="first_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="last_name" id="lastName" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="last_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
<%--         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="ssoId" id="ssoId" class="form-control 
 
input-sm" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="ssoId" id="ssoId" class="form-control 
 
input-sm" />
                            <div class="has-error">
                                <form:errors path="ssoId" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div> --%>
 
<%--  
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="email" id="email" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div> --%>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="courses">Courses</label>
                <div class="col-md-7">
                    <form:select path="courses" items="${available_courses}" multiple="true" itemValue="id"
 
itemLabel="title" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="courses" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='student/all' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='student/all' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>

