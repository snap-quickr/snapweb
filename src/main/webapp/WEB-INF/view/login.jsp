<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ShopoWeb</title>
<meta http-equiv="Content-Type"	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
	<!--[if IE 6]>
	<link rel="stylesheet" type="text/css" href="iecss.css" />
	<![endif]-->
	<script type="text/javascript" src="js/windowopen.js"></script>
	<script type="text/javascript" src="js/boxOver.js"></script>
	<script type="text/javascript">
	function validate(form) {
	    if (form.password.value == "") {
	      alert("Error: please enter your password");
	      return false;
	    }		    	
	    if (form.email.value == "") {
	      alert("Error: enter your email!");
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
		<%@include file="footer.jsp"%> 		
	</div>
</body>
</html>