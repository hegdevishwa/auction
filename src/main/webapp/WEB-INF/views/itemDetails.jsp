<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Details</title>
<script type="text/javascript">

function confirmForChanges(value) {
	  /* var r = confirm("Do you want to proceed"); */
	  var inputValue = document.getElementById("itemBid").value;
	  if( value >= inputValue )
      {
         alert( "The Price must be greater than latest price" );
         document.myItemForm.itemBid.focus() ;
         return false;
      }
	  return true;//if true then submit else don't submit
	}
</script>
</head>
<body>
	<h1>Item Details:</h1>
	<a href="/auction/home">Home</a>
	<form:form action="createbidForItem" method="POST" commandName="bid" name="myItemForm" onsubmit="return confirmForChanges(${bid.bidPrice});">
		<center>
			<table border="1" width="30%" cellpadding="5">
				<thead>
					<tr>
						<th colspan="2">Enter Bid Details</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2" align="center"><img
							src="data:image/jpeg;base64,${item.base64EncodedImage}" alt="..."
							width="200" height="200"></td>
					</tr>
					<tr>
						<td><label for="name">Item Name</label></td>
						<td>${item.name}</td>
					</tr>
					<tr>
						<td><label for="description">Description</label></td>
						<td>${item.description}</td>
					</tr>
					<tr>
						<td><label for="baseBidPrice">Base bid price</label></td>
						<td>${item.baseBidPrice}</td>
					</tr>
					<tr>
						<td><label for="expiryDate">Auction Expiry date</label></td>
						<td>${item.expiryDate}</td>
					</tr>
					<tr>
						<td><label for="username">Latest Bid User Name</label></td>
						<td>${user.fname}</td>
					</tr>
					<tr>
						<td><label for="username">Latest Bid</label></td>
						<td>${bid.bidPrice}</td>
					</tr>
					<tr style="display:none">
						<td><label for="itemId">ItemID</label></td>
						<td><form:hidden path="itemId" value="${item.itemId}"/></td>
					</tr>
					<tr style="display:none">
						<td><label for="userId">userID</label></td>
						<td><form:hidden path="userId" value="${currentUser.userId}"/></td>
					</tr>
					<tr>
						<td><label for="bidPrice">Bid Price</label></td>
						<td><form:input path="bidPrice" id="itemBid"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><form:button id="submit" onclick="myFunc()">Submit</form:button></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>
</body>
</html>