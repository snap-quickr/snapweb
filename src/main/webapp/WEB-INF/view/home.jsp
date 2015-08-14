<%@page import="org.snap.shopoweb.dao.LocationDao"%>
<%@page import="org.snap.shopoweb.beans.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<% 
		HashMap<String,List<Product>> hashMap = (HashMap<String,List<Product>>)request.getAttribute("allProducts"); 
	%>
</head>
<body>
	<div id="header">
	  Hello ${userName}
      <div>
      	<a href="user.htm?userId=${userId}">${userName}</a>
      </div>
    </div>
	
	<form action="add.htm" method="get">
		<input type="hidden" name="userId" value="${userId}"/>
		<input type="submit" value="Add Product"/>
	</form>
	<% 
		for(String locationName:hashMap.keySet()){
			out.println(locationName+"<br/>");
			for(Product prod : hashMap.get(locationName)){
				out.println("Name: "+prod.getProductName()+", ");
				out.println("Desc: "+prod.getProductDetail()+"<br/>");			
			}
			out.println("<hr/>");
		}
	%>
</body>	
</html>