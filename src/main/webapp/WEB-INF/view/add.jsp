<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="add.htm" >
	<center>
		Location:<select name ="locationId">
		<option value="0">--CHOOSE--</option>
		<option value="1">Gurgaon</option>
		<option value="2">Delhi</option>
		<option value="3">Mumbai</option>
		<option value="4">Banglore</option>
		<option value="5">Hydrabad</option>
		<option value="6">Jaipur</option>
		<option value="7">Chennai</option>
		<option value="8">Kolkata</option>
		<option value="9">Amritsar</option>
		<option value="10">Shimla</option>
		</select><br><br>
		Category :<select name="categoryId">
		<option value="0">--CHOOSE--</option>
		<option value="1">Cars & Bikes</option>
		<option value="2">Mobiles & Tablets</option>
		<option value="3">Electronics & Appliances</option>
		<option value="4">Real Estate</option>
		<option value="5">Home & LifeStyle</option>
		</select> <br>
		<br> Product Name: <input type="text" name="productName" /><br>
		<br> Price : <input type="text" name="price" /><br>
		<br> Description : <input type="text" name="productDetail" /><br>
		<br> <input type="submit" value="Submit" />
		</center>
	</form>
</body>
</html>