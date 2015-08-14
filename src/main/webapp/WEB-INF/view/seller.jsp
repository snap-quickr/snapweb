<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.snap.shopoweb.beans.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<% 
	User user = (User) request.getAttribute("user");
	out.println(user.getUserName());
%>
<title>Hello <%= user.getUserName()%></title>
<meta http-equiv="Content-Type"	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/windowopen.js"></script>
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>
	<div id="main_container">
		<div class="top_bar">
			<div class="top_offers"><marquee><h1>Get exciting offers at ShopoWEb...!<h1/></marquee></div>
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
			</div>
			<!-- end of oferte_content-->
		</div>
		<div id="main_content">
			<div id="menu_tab">
		        <ul class="menu">
		          <li><a href="home.htm" class="nav1" id="">Home</a></li>
		          <!-- <li class="divider"></li> -->
		          <li><a href="signup.htm" class="nav2">Sign up</a></li>
		          <!-- <li class="divider"></li> -->
		          <li><a href="login.htm" class="nav3">Login</a></li>
		          <!-- <li class="divider"></li> -->
		          <li><a href="user.htm?userId=1" class="nav4">My account</a></li>
		          <!-- <li class="divider"></li> -->
		          <li><a href="contact.html" class="nav6">Contact Us</a></li>
		          <!-- <li class="divider"></li> -->
		        </ul>
      		</div>
			<!-- end of menu tab -->
			<div class="center_content">
				<div class="center_signup_content">
					<center>
						<h4>Seller details</h4>
					</center>
					<div class="seller_labels">Name:</div>
					<div class="seller_output"><%= user.getUserName() %></div><br/>
					<div class="seller_labels">ID:</div>
					<div class="seller_output"><%= user.getUserId() %></div><br/>
					<div class="seller_labels">Email:</div>
					<div class="seller_output"><%= user.getUserEmail() %></div><br/>
					<div class="seller_labels">Contact:</div>
					<div class="seller_output"><%= user.getUserContact() %></div><br/>
					<a href="#" class="compare"><center>Contact
							seller</center></a><br/>
				</div>
			</div>
		</div>
		<!-- end of main content -->
		<div class="footer">
			<div class="left_footer">
				<img src="images/footer_logo.png" alt="" width="170" height="49" />
			</div>
			<div class="center_footer">
				&copy; Copyright Team ShopoWeb Inc.<br /> <br /> <img
					src="images/payment.gif" alt="" />
			</div>
			<div class="right_footer">
				<a href="#">home</a> <a href="#">about</a> <a href="#">sitemap</a> <a
					href="#">rss</a> <a href="contact.html">contact us</a>
			</div>
		</div>
	</div>
</body>
</html>