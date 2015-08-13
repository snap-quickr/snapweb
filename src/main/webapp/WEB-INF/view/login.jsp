<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<script type="text/javascript">
		function validate(form) {
			if (form.pass.value == "") {
				alert("Error: please enter your password");
				form.pwd.focus();
				return false;
			}
	
			if (form.pass.value.length < 6) {
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
	<h2>User Login</h2>
	<form method="POST" action="home.htm" onsubmit="return validate(this);">
		<table>
			<tr>
				<td>Email Id</td><td><input type="text" name="email"/></td>			
			</tr>
			<tr>
				<td>Password</td><td><input type="password" name="password"/></td>			
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="source" value="login"/>
	</form>
</body>
</html>