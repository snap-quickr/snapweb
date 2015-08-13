
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
	function validate(form) {
		if (form.pass1.value == "" || form.pass2.value == "") {
			alert("Error: please enter your password");
			form.pwd.focus();
			return false;
		}

		if (form.pass1.value != form.pass2.value) {
			alert("Error: Passowrd entered are not same");
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

<h2>New User Register here</h2>
<form method="POST" action="addUser.htm" onsubmit="return validate(this);">
	<table>
		<tr>
			<td>Name</td>
			<td><input name="name" type="text" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input name="email" type="text" /></td>
		</tr>
		<tr>
			<td>Contact</td>
			<td><input name="contact" type="text" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input name="pass1" type="password" /></td>
		</tr>
		<tr>
			<td>Re-type Password</td>
			<td><input name="pass2" type="password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form>