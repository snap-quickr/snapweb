<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello!!! SHOPO USER</h1>
	NAME:${item:userName}<br/>
	ID:${item:userId}<br/>
	EMAIL:${item:userEmail}<br/>
	CONTACT:${item:userContact}<br/>
	
	<h1> SELECTED PRODUCT DETAIL ..</h1>
	<c:forEach items="${plist}" var="element">
	<tr>
		<td>${element.productId}</td>
		<td>${element.productDetails}</td>
	</tr>
	</c:forEach>
	
	
	

</body>
</html>