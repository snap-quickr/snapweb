<%@page import="org.snap.shopoweb.dao.LocationDao"%>
<%@page import="org.snap.shopoweb.beans.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopo WEb</title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
    <link rel="stylesheet" type="text/css" href="css/home.css" />
    <script type="text/javascript" src="js/boxOver.js"></script>
    <% 
		HashMap<String,List<Product>> hashMap = (HashMap<String,List<Product>>)request.getAttribute("allProducts"); 
	%>
  </head>

<body>
    
    <div id="main_container">
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
				</div>
				<!-- end of oferte_content-->
		</div>

	    <div id="main_content">
	      <div id="menu_tab">
	        <ul class="menu">
	          <li><a href="home.htm" class="nav1" id="">Home</a></li>
	          <li><a href="signup.htm" class="nav2">Sign up</a></li>
	          <li><a href="login.htm" class="nav3">Login</a></li>
	          <li><a href="user.htm?userId=${userId}" class="nav4">My account</a></li>
	          <li><a href="add.htm?userId=${userId}" class="nav6">Add Product</a></li>
	        </ul>
	      </div>        
	      <!-- <div class="center_content"> -->
	      	<% 
	      	for(String locationName:hashMap.keySet()){
	      	  List<Product> products = (List<Product>)hashMap.get(locationName);
	      	  if(products.size()==0)
	      	      continue;
	      	%>
	      		<div class="center_content">
	      		<%=locationName%><hr/>		      		
	      		<%
	      	    for(Product p: (List<Product>)hashMap.get(locationName)){
	      		%>			      		
	      		<div class="prod_box"><%--  <%=locationName%> --%>
      			<div class="top_prod_box"></div>		          
		          <div class="center_prod_box">
		            <div class="product_title">
		        		<a href="showProduct.htm?locationId=<%=p.getLocationId()%>&productId=<%=p.getProductId()%>">
		        			<%=p.getProductName()%>
		        		</a>
		        	</div>
		            <div class="product_img"><a href="showProduct.htm?locationId=<%=p.getLocationId()%>&productId=<%=p.getProductId()%>"><img src="images/laptop.gif" alt="" border="0" /></a></div>
		            <div class="prod_price">Price: <span class="price"><%=p.getPrice()%></span></div>
		          </div>
		          <div class="bottom_prod_box">	          </div>		           
		          </div>
      			<%
      			}
      			%>
	      		</div>      	
	      	<%}%>
	      <!-- </div> -->
	     </div>
	     <!-- end of main content -->
	     <%@include file="footer.jsp"%>
      </div>
	</body>
</html>