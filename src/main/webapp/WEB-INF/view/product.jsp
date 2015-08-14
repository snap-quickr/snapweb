<%@page import="org.snap.shopoweb.beans.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Product details</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/windowopen.js"></script>
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>
<% Product product = (Product)request.getAttribute("product");%>
<div id="main_container">
    <div class="top_bar">
      <div class="top_offers">
        Get exciting offers!
      </div>
    </div>

    <div id="header">
      <div id="logo"> <a href="#"><img src="images/eMart2.jpg" alt="" border="0" width="237" height="140" /></a> </div>
      <div class="oferte_content">
        <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
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
<!--       <div class="crumb_navigation"> Navigation: <span class="current">Home</span> </div> -->
    <div class="center_content">

      <div class="center_title_bar"><%= product.getProductId() %></div>
      <div class="prod_box_big">
        <div class="top_prod_box_big"></div>
        <div class="center_prod_box_big">
          <div class="product_img_big"> 
            <a href="javascript:popImage('images/big_pic.jpg','Zoomed view')" title="header=[Zoom] body=[&nbsp;] fade=[on]">
              <img src="images/laptop.gif" alt="" border="0" />
            </a>
            <div class="thumbs"> 
              <a href="#" title="header=[Thumb1] body=[&nbsp;] fade=[on]">
                <img src="images/thumb1.gif" alt="" border="0" />
              </a>
              <a href="#" title="header=[Thumb2] body=[&nbsp;] fade=[on]">
                <img src="images/thumb1.gif" alt="" border="0" />
              </a>
              <a href="#" title="header=[Thumb3] body=[&nbsp;] fade=[on]">
                <img src="images/thumb1.gif" alt="" border="0" />
              </a>
            </div>
          </div>
          <div class="details_big_box">
            <div class="product_title_big"><%= product.getProductId() %></div>
            <div class="product_name"><%= product.getProductName() %></div>
            
            <div class="specifications"> Seller: <span class="blue"><%= product.getUserId() %></span><br />
              Category: <span class="blue"><%= product.getCategoryId() %></span><br />
              Location: <span class="blue"><%= product.getLocationId() %></span><br />
            </div>
            <div class="prod_price_big"><span class="price"><%= product.getPrice() %></span></div>
            <a href="#" class="addtocart">add to cart</a> <a href="seller.htm?userId=<%= product.getUserId() %>" class="compare">Buy</a>
          </div>
        </div>
        <div class="desc_big_box">
            <%= product.getProductDetail() %>
        </div>
        <div class="bottom_prod_box_big"></div>
      </div>    
  </div>
  <!-- end of main content -->
  <div class="footer">
    <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>
    <div class="center_footer"> Template name. All Rights Reserved 2008<br />
      <a href="http://csscreme.com"><img src="images/csscreme.jpg" alt="csscreme" border="0" /></a><br />
      <img src="images/payment.gif" alt="" /> </div>
    <div class="right_footer"> <a href="#">home</a> <a href="#">about</a> <a href="#">sitemap</a> <a href="#">rss</a> <a href="contact.html">contact us</a> </div>
  </div>
</div>
<!-- end of main_container -->
</body>
</html>
