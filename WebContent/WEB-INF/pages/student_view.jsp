<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
    <h2>Submitted Student Information</h2>
    <table>
        <tr>
            <td>Name :</td>
            <td>${sname}</td>
        </tr>
        <tr>
            <td>ID :</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>Gender :</td>
            <td>${ssex}</td>
        </tr>
        <tr>
            <td>Date of Birth :</td>
            <td>${sdob}</td>
        </tr>
    </table>
</body>
</html>