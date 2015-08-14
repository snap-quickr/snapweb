<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Electronix Store - Details</title>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/windowopen.js"></script>
<script type="text/javascript" src="js/boxOver.js"></script>
<script type="text/javascript">
    function validate(form) {
      if (form.password.value == "") {
        alert("Error: please enter your password");
        form.pwd.focus();
        return false;
      }
  
      if (form.password.value.length < 6) {
        alert("Error: Password must have at least six characters!");
        form.pwd.focus();
        return false;
      }
  
      if (form.email.value == "") {
        alert("Error: enter your email!");
        form.email.focus();
        return false;
      }
  
      re2 = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
      if (!re2.test(form.email.value)) {
        alert("Error: Invalid format for email!");
        form.email.focus();
        return false;
      }
      return true;
    }
</script>
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
				<div class="left_menu_corner"></div>
				<ul class="menu">
					<li><a href="#" class="nav1" id=""> Home</a></li>
					<li class="divider"></li>
					<li><a href="#" class="nav2">Products</a></li>
					<li class="divider"></li>
					<li><a href="#" class="nav3">Specials</a></li>
					<li class="divider"></li>
					<li><a href="#" class="nav4">My account</a></li>
					<li class="divider"></li>
					<li><a href="#" class="nav4">Sign Up</a></li>
					<li class="divider"></li>
					<li><a href="#" class="nav5">Shipping</a></li>
					<li class="divider"></li>
					<li><a href="contact.html" class="nav6">Contact Us</a></li>
					<li class="divider"></li>
				</ul>
				<div class="right_menu_corner"></div>
			</div>
			<!-- end of menu tab -->
			<div class="center_content">
				<div class="center_login_content">
					<center>
						<h4>Login</h4>
						<form action="home.htm" method="post"
							onsubmit="return validate(this);">
							<div class="login_labels">Email</div>
							<input type="text" name="email" class="login_input"><br />
							<div class="login_labels">Password</div>
							<input type="password" name="password" class="login_input"><br />
							<input type="hidden" name="source" value="login"/>
							<input type="submit" value="Login"
								style="float: left; width: 20%; margin-top: 1%; margin-bottom: 1%; margin-left: 40%; margin-right: 40%; background: #0097A7; border: none; padding-top: 1%; padding-bottom: 1%; color: #fff;">
						</form>							
					</center>
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