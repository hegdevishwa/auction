<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bid Details</title>
</head>
<body>
	<form:form action="createbidForItem" method="POST" commandName="bid">
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Enter Bid Details</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><label for="uname">User Name</label></td>
						<td>${uname}</td>
					</tr>
					<tr>
						<td><label for="bidPrice">Bid Price</label></td>
						<td><form:input path="bidPrice" /></td>
					</tr>
					<tr>
						<td><form:button id="submit">Submit</form:button></td>
						<td><input type="reset" value="Reset" /></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>
</body>
</html>