<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/register.css" rel="stylesheet"
	type="text/css" />
<title>Registration</title>
</head>
<body>
<div id="registration-form">
<div class='fieldset'>
  <legend>Register Here</legend>
		<form:form action="auctionRegistration" method="POST"
			commandName="user" style="border: none;" >
			
			<div class='row'>
				<label for='firstName'>First Name</label>
				<form:input type="text" placeholder="First Name" path="firstName" />
				<form:errors path="firstName" cssClass="error"/>
			</div>
			
			
			<div class='row'>
				<label for='lastName'>Last Name</label>
				<form:input type="text" placeholder="Last Name" path="lastName" />
			</div>
			
			<div class='row'>
				<label for='userName'>User Name</label>
				<form:input type="text" placeholder="User Name" path="userName" />
				<form:errors path="userName" cssClass="error"/>
			</div>
			
			<div class='row'>
				<label for='password'>User Password</label>
				<form:input type="password" placeholder="User Password"  path="password" />
				<form:errors path="password" cssClass="error"/>
			</div>
			
			<div class='row'>
				<label for='address'>Address</label>
				<form:input type="text" placeholder="Address" path="address" />
			</div>
			<form:button type="submit" id="submit">Submit</form:button>
			<input type="reset" id ="reset" value="Reset"/>
			<a href="/auction"><input type="button" id= "loginButton"value="Login Here"/></a>
			
		</form:form>
	</div>
</div>
</body>
</html>