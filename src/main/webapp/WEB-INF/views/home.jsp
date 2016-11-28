<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href="resources/css/home.css" rel="stylesheet"
	type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
</head>
<body>
<div id="registration-form">
<div class='fieldset'>
	 <legend id="legend">Home Page</legend>
	<a href="javascript:formSubmit()"><input type="button" style="float: right;margin-top: 57px;" id= ""value="Logout"/></a>
	<!-- For login user -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<table>
		<tr>
			<td><c:if
					test="${pageContext.request.userPrincipal.name != null}">
					<h2>Welcome ${firstName}</h2>
				</c:if></td>
		</tr>
	</table>
	<div id="tabs">
		<ul>
			<li><a href="items">List of Sales</a></li>
			<li><a href="createSaleItem">Create Sale Item</a></li>
		</ul>
	</div>
	</div>
	</div>
</body>
</html>