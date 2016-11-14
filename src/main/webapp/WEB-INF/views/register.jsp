<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reg</title>
</head>
<body>
	<form:form action="auctionRegistration" method="POST"
			commandName="user">
			<center>
				<table border="1" width="30%" cellpadding="5">
					<thead>
						<tr>
							<th colspan="2">Enter Information Here</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><label for="fname">Name</label></td>
							<td><form:input path="fname" /></td>
						</tr>
						<tr>
							<td><label for="lname">Last Name</label></td>
							<td><form:input path="lname" /></td>
						</tr>
						<tr>
							<td><label for="emialId">Email</label></td>
							<td><form:input path="emialId" /></td>
						</tr>
						<tr>
							<td><label for="userName">UserName</label></td>
							<td><form:input path="userName" /></td>
						</tr>
						<tr>
							<td><label for="password">UserPassword</label></td>
							<td><form:input path="password" /></td>
						</tr>

						<tr>
							<td><label for="mobile">Mobile</label></td>
							<td><form:input path="mobile" /></td>
						</tr>

						<tr>
							<td><label for="address">Address</label></td>
							<td><form:input path="address" /></td>
						</tr>
						<tr>
							<td><form:button id="submit">Submit</form:button></td>
							<td><input type="reset" value="Reset" /></td>
						</tr>
						<tr>
							<td colspan="2">Already registered!! <a href="index">Login
									Here</a></td>
						</tr>
					</tbody>
				</table>
			</center>
		</form:form>
</body>
</html>