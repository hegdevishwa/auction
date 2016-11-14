<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<a href="javascript:formSubmit()"> Logout</a>
	<sec:authorize access="hasRole('ROLE_USER')">
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
						<h2>User : ${pageContext.request.userPrincipal.name}</h2>
					</c:if></td>
			</tr>
			<tr>
				<td><a href="createsaleitem"> Create Sale Item</a></td>
			</tr>
		</table>



	</sec:authorize>
</body>
</html>