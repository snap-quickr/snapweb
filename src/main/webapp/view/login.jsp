
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<h2>User Login</h2>
<form:form method="POST" action="validate.jsp" modelAttribute="validate"
	onsubmit="return validate(this);">
	<table>
		<tr>
			<td><form:label path="email">Email Id</form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="pass">Password</form:label></td>
			<td><form:input path="pass" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>