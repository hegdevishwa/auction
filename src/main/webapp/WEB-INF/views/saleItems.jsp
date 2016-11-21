<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/saleItems.css" rel="stylesheet"
	type="text/css" />
<title>Sale items</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Description</th>
				<th>Base bid price</th>
				<th>Expiry date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<td><img
						src="data:image/jpeg;base64,${item.base64EncodedImage}" alt="..."
						width="100" height="100"></td>
					<td>${item.name}</td>
					<td>${item.description}</td>
					<td>${item.baseBidPrice}</td>
					<td>${item.expiryDate}</td>
					<td><a href="items/${item.itemId}">Bid for this item</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>