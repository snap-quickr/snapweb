<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>User Login</h2>
<form:form method="POST" action="validate.jsp" modelAttribute="validate">
   <table>
    <tr>
        <td><form:label path="email">Email Id</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="pass">Password</form:label></td>
        <td><form:input path="pass" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>