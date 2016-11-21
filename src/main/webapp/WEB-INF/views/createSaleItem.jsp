<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/createSale.css" rel="stylesheet"
	type="text/css" />
<title>Create Sale Item</title>
</head>
<body>
<div id="createSale-form">
<div class='fieldset'>
	
	<legend>Enter the item details</legend>
		<form:form action="items" method="POST" commandName="item"
			enctype="multipart/form-data">
			
			<div class='row'>
				<label for="name">Name:</label>
				<form:input path="name"  placeholder="Name"  />
				<form:errors path="name" cssClass="error" />
			</div>
			
			<div class='row'>
				<label for="description">Description:</label>
				<form:input type="text" placeholder="Description" path="description" />
			</div>
			
			<div class='row'>
				<label for="category">Category:</label>
				<form:select path="category">
				<form:options items="${categories}" />
						</form:select>
			</div>
			
			<div class='row'>
				<label for="baseBidPrice">Base bid price:</label>
				<form:input type="text" path="baseBidPrice" placeholder="Base bid price"/>
				<form:errors path="baseBidPrice"
							cssClass="error" />
			</div>
			
			<div class='row'>
				<label for="file">Upload an image</label>
				<input type="file" id="file" name="file" />
			</div>
			
			<form:button id="submit">Submit</form:button>
		
		</form:form>
	</div>
	</div>
</body>
</html>