<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body onload='document.f.j_username.focus();'>

	<p>
	<h3>Welcome to Online-Auction</h3>
	</p>

	<div>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form name='loginForm' action="j_spring_security_check" method='POST'>


			<table>
				<tr>
					<td><h3>Sign in:</h3></td>
				</tr>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="j_username" id="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="j_password" id="password"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Login"></td>
					<td><a href="register">Register</a></td>
					<td><a href="createsaleitem"> Create Sale Item</a></td>
				</tr>

			</table>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>