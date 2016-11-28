<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{
  background:#b4b4b4;
}
#itemDetail-form {
  font-family:'Open Sans Condensed', sans-serif;
	width: 400px;
  min-width:250px;
	margin: 20px auto;
	position: relative;
}

#itemDetail-form .fieldset {
	background-color:#d5d5d5;

	border-radius: 3px;
  
}

 #itemDetail-form legend {
	text-align: center;
	background: #364351;
	width: 100%;
	padding: 30px 0;
	border-radius: 3px 3px 0 0;
	color: white;
font-size:2em;
}

  
  body{
  background:#b4b4b4;
}

#itemDetail-form {
  font-family:'Open Sans Condensed', sans-serif;
	width: 400px;
  min-width:250px;
	margin: 20px auto;
	position: relative;
}

#itemDetail-form .fieldset {
	background-color:#d5d5d5;

	border-radius: 3px;
  
}

 #itemDetail-form legend {
	text-align: center;
	background: #364351;
	width: 100%;
	padding: 30px 0;
	border-radius: 3px 3px 0 0;
	color: white;
font-size:2em;
}

.fieldset form{
  margin:0 auto;
  display:block;
  width:100%;
  padding:30px 20px;
  box-sizing:border-box;
  border-radius:0 0 3px 3px;
}
.placeholder #itemDetail-form label {
	display: none;
}
 .no-placeholder #itemDetail-form label{
margin-left:5px;
  position:relative;
  display:block;
  color:grey;
  text-shadow:0 1px white;
  font-weight:bold;
}
/* all */
::-webkit-input-placeholder { text-shadow:1px 1px 1px white; font-weight:bold; }
::-moz-placeholder { text-shadow:0 1px 1px white; font-weight:bold; } /* firefox 19+ */
:-ms-input-placeholder { text-shadow:0 1px 1px white; font-weight:bold; } /* ie */
#itemDetail-form input[type=text] {
	padding: 15px 20px;
	border-radius: 1px;
  margin:5px auto;
  background-color:#f7f7f7;
	border: 1px solid silver;

	-webkit-box-shadow: inset 0 1px 5px rgba(0,0,0,0.2);
	box-shadow: inset 0 1px 5px rgba(0,0,0,0.2), 0 1px rgba(255,255,255,.8);
	width: 100%;

	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
  -webkit-transition:background-color .5s ease;
-moz-transition:background-color .5s ease;
-o-transition:background-color .5s ease;
-ms-transition:background-color .5s ease;
transition:background-color .5s ease;
}
.no-placeholder #itemDetail-form input[type=text] {
	padding: 10px 20px;
}

#itemDetail-form input[type=text]:active, .placeholder #itemDetail-form input[type=text]:focus {
	outline: none;
	border-color: silver;
  background-color:white;
}


#itemDetail-form input[type=password] {
	padding: 15px 20px;
	border-radius: 1px;
  margin:5px auto;
  background-color:#f7f7f7;
	border: 1px solid silver;

	-webkit-box-shadow: inset 0 1px 5px rgba(0,0,0,0.2);
	box-shadow: inset 0 1px 5px rgba(0,0,0,0.2), 0 1px rgba(255,255,255,.8);
	width: 100%;

	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
  -webkit-transition:background-color .5s ease;
-moz-transition:background-color .5s ease;
-o-transition:background-color .5s ease;
-ms-transition:background-color .5s ease;
transition:background-color .5s ease;
}
.no-placeholder #itemDetail-form input[type=password] {
	padding: 10px 20px;
}

#itemDetail-form input[type=password]:active, .placeholder #itemDetail-form input[type=password]:focus {
	outline: none;
	border-color: silver;
  background-color:white;
}
#submit {
  font-family:'Open Sans Condensed', sans-serif;
  text-transform:uppercase;
  outline:none;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
	width: 100%;
	background-color: #5C8CA7;
	padding: 10px;
	color: white;
	border: 1px solid #3498db;
	border-radius: 3px;
	font-size: 1.5em;
	font-weight: bold;
	margin-top: 5px;
	cursor: pointer;
  position:relative;
  top:0;
}

#submit:hover {
	background-color: #2980b9;
}

#submit:active {
background:#5C8CA7;
}


.parsley-error-list{
background-color:#C34343;
padding: 5px 11px;
margin: 0;
list-style: none;
border-radius: 0 0 3px 3px;
margin-top:-5px;
  margin-bottom:5px;
  color:white;
  border:1px solid #870d0d;
  border-top:none;
    -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  position:relative;
  top:-1px;
  text-shadow:0px 1px 1px #460909;
    font-weight:700;
  font-size:12px;
}
.parsley-error{
	border-color:#870d0d!important;
  border-bottom:none;
}
#itemDetail-form select{
	width:100%;
	padding:5px;
}
::-moz-focus-inner {
  border: 0;
}

input:read-only { 
    background-color: yellow;
}
</style>
<title>Item Details</title>
<script type="text/javascript">

function confirmForChanges(value,value1) {
	  /* var r = confirm("Do you want to proceed"); */
	  var inputValue = document.getElementById("itemBid").value;
	  if( value >= inputValue )
      {
         alert( "The Price must be greater than latest price" );
         document.myItemForm.itemBid.focus() ;
         return false;
      }
	  
	  else if( value1 >= inputValue )
	    {
	       alert( "The Price must be greater than Base Bid Price" );
	       document.myItemForm.itemBid.focus() ;
	       return false;
	    }
	  return true;//if true then submit else don't submit
	}
	
</script>
</head>
<body>
<div id="itemDetail-form">
<div class='fieldset'>
<legend>Item Details</legend>

	<form:form action="createbidForItem" method="POST" commandName="bid" name="myItemForm" onsubmit="return confirmForChanges(${bid.bidPrice},${item.baseBidPrice});">
		<center>
			<table  cellpadding="5">
				<thead>
					
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
						<td id="baseBidPrice">${item.baseBidPrice}</td>
					</tr>
					<tr>
						<td><label for="expiryDate">Auction Expiry date</label></td>
						<td>${item.expiryDate}</td>
					</tr>
					<tr>
						<td><label for="username">Latest Bid User Name</label></td>
						<td>${user.firstName}</td>
					</tr>
					<tr>
						<td><label for="bidPrice">Latest Bid</label></td>
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
					<tr>
						<td colspan="2" align="center"><a href="/auction/home"><input type="button" id="submit" value="Back To Home"/></a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>
	</div>
	</div>
</body>
</html>