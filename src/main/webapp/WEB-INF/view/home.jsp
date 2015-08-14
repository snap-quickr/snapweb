<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
	Hello ${userName}
	
	<form action="add.htm" method="get">
		<input type="hidden" name="userId" value="${userId}"/>
		<input type="submit" value="Add Product"/>
	</form>
</body>	
</html>