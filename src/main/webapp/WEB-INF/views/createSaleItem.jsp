<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Sale Item</title>
</head>
<body>
	<div>
		<h3>Enter the item details below:</h3>
	</div>

	<fieldset>
		<form:form action="items" method="POST" commandName="item" enctype="multipart/form-data">
			<table>
				<tr>
					<td><label for="name">Name:</label></td>
					<td><form:input path="name" id="name" /></td>
				</tr>
				<tr>
					<td><label for="description">Description:</label></td>
					<td><form:input path="description" id="description" /></td>
				</tr>
				<tr>
					<td><label for="category">Category: </label></td>
					<td><form:select path="category" id="category">
							<form:options items="${categories}" />
						</form:select></td>
				</tr>
				<tr>
					<td><label for="baseBidPrice">Base bid price:</label></td>
					<td><form:input path="baseBidPrice" id="baseBidPrice" /></td>
				</tr>

				<tr>
					<td><label for="file">Upload an image</label></td>
					<td><input type="file" id="file" name="file" /></td>
				</tr>
				<tr>
					<td><form:button id="submit">Submit</form:button></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>