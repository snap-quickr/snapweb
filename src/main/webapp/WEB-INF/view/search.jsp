<%@page import="org.snap.shopoweb.beans.Location"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.snap.shopoweb.dao.LocationDao"%>
<%@page import="org.snap.shopoweb.beans.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Shopo WEb</title>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/boxOver.js"></script>
<% 
    ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		HashSet<Product> arrListProd=(HashSet<Product>)request.getAttribute("searchRes");
		LocationDao locDao= (LocationDao)context.getBean("locationDao");
        
		List<Location> locations=locDao.getAllLocations();
	%>
</head>

<body>

	<div id="main_container"></div>
	<div class="top_bar">
		<div class="top_offers">Get exciting offers!</div>
	</div>
	<div id="header">
		<div id="logo">
			<a href="#"><img src="images/logo.png" alt="" border="0"
				width="237" height="140" /></a>
		</div>
		<div class="oferte_content">
			<div class="top_divider">
				<img src="images/header_divider.png" alt="" width="1" height="164" />
			</div>
			<form action="search.htm" method="post">
				<select name="location">
					<%for(Location loc:locations){ %>
					<option value=<%= loc.getLocationId() %>><%= loc.getLocationName() %></option>
					<%} %>
				</select> <input type="search" name="toSearch" /> <input type="submit" />
			</form>
		</div>
		<!-- end of oferte_content-->
	</div>

	<div id="main_content">
		<div id="menu_tab">
			<ul class="menu">
				<li><a href="home.htm" class="nav1" id="">Home</a></li>
				<li><a href="signup.htm" class="nav2">Sign up</a></li>
				<li><a href="login.htm" class="nav3">Login</a></li>
				<li><a href="user.htm?userId=${userId}" class="nav4">My
						account</a></li>
				<li><a href="add.htm?userId=${userId}" class="nav6">Add
						Product</a></li>
			</ul>
		</div>
		<div class="center_content">
			<% 
			Iterator<Product> itr = arrListProd.iterator();
			while(itr.hasNext()){
			Product p=itr.next();
      	%>
			<div class="prod_box">
				<div class="top_prod_box"></div>
				<div class="center_prod_box">
					<div class="product_title">
						<a
							href="showProduct.htm?locationId=<%=p.getLocationId()%>&productId=<%=p.getProductId()%>">
							<%=p.getProductName()%>
						</a>
					</div>
					<div class="product_img">
						<a href="details.html"><img src="images/laptop.gif" alt=""
							border="0" /></a>
					</div>
					<div class="prod_price">
						<span class="price"><%=p.getPrice()%></span>
					</div>
				</div>
				<div class="bottom_prod_box"></div>
				<!-- <div class="prod_details_tab"> <a href="#" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="#" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="#" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.html" class="prod_details">details</a> </div> -->
			</div>
			<%
      	}%>
		</div>
	</div>
	<!-- end of main content -->
	<div class="footer">
		<div class="center_footer">
			ShopoWeb. All Rights Reserved 2015<br />
			<!-- <a href="http://csscreme.com"><img src="images/csscreme.jpg" alt="csscreme" border="0" /></a><br />
	        <img src="images/payment.gif" alt="" /> </div> -->
			<!-- <div class="right_footer"> <a href="#">home</a> <a href="#">about</a> <a href="#">sitemap</a> <a href="#">rss</a> <a href="contact.html">contact us</a> </div> -->
		</div>
	</div>

</body>
</html>