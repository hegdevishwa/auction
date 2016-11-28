<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/createSale.css" rel="stylesheet"
	type="text/css" />
<script src="resources/js/form-validation.js" type="text/javascript"></script>
<title>Create Sale Item</title>
</head>
<body>
	<div id="createSale-form">
		<div class='fieldset'>

			<legend>Enter the item details</legend>
			<form:form action="items" method="POST" commandName="item"
				enctype="multipart/form-data" name="createSale"
				onsubmit="return validateForm();">
				<div id="error" class="error"></div>
				<form:hidden path="userId" value="${userId}" />
				<div class='row'>
					<label for="name">Name:</label>
					<form:input path="name" placeholder="Name" id="name" />
					<form:errors path="name" cssClass="error" id="nameError" />
				</div>

				<div class='row'>
					<label for="description">Description:</label>
					<form:input type="text" placeholder="Description"
						path="description" />
				</div>

				<div class='row'>
					<label for="category">Category:</label>
					<form:select path="category">
						<form:options items="${categories}" itemValue="value"
							itemLabel="value" />
					</form:select>
				</div>

				<div class='row'>
					<label for="baseBidPrice">Base bid price:</label>
					<form:input type="text" path="baseBidPrice"
						placeholder="Base bid price" id="baseBidPrice" />
					<form:errors path="baseBidPrice" cssClass="error"
						id="baseBidPriceError" />
				</div>

				<div class='row'>
					<label for="file">Upload an image</label> <input type="file"
						id="file" name="file" />
				</div>

				<form:button id="submit">Submit</form:button>

			</form:form>
		</div>
	</div>
</body>
</html>