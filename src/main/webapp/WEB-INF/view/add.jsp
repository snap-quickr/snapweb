	<%@page import="org.snap.shopoweb.beans.Location"%>
<%@page import="org.snap.shopoweb.beans.Category"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
<%
    List<Location> locations = (List<Location>) request.getAttribute("locations");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
%>
</head>
<body>
	<div>
		<form action="saveProduct.htm" method="post">

			Location: <select name="locationId">
				<option value="0">--CHOOSE--</option>
				<%
				    for (Location location : locations)
				        out.print("<option value=" + location.getLocationId() + ">" + location.getLocationName() + "</option>");
				%>
			</select><br /> <br /> Category: <select name="categoryId">
				<option value="0">--CHOOSE--</option>
				<%
				    for (Category category : categories)
				        out.print("<option value=" + category.getCategoryId() + ">" + category.getCategoryName() + "</option>");
				%>
			</select> <br /> <br /> 
			Product Name: <input type="text" name="productName" /><br /> <br /> 
			Price : <input type="text" name="price" /><br /> <br />
			Description : <input type="text" name="productDetail" /><br /> <br />
			<input type="hidden" name="userId" value="<%=request.getAttribute("userId")%>"/>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>