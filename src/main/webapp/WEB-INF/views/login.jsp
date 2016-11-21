<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/login.css" rel="stylesheet"
	type="text/css" />
<title>Welcome</title>

</head>
<body onload='document.f.j_username.focus();'>
<div class="body"></div>
		<div class="grad"></div>
		
		<div class="header">
			<div>Welcome to<span>Online-Auction</span></div>
		</div>
	<div  class="login">
	<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form name='loginForm'
			action="j_spring_security_check" method='POST'>
			
			<input type="text" name="j_username" id="username" placeholder="username" >
			<input type="password" name="j_password" id="password" placeholder="password"  >
			<input type="submit" name="submit" value="Login">
			<a href="register"><input type="register" value="Register"/></a>
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			
		</form>
	</div>

</body>
</html>