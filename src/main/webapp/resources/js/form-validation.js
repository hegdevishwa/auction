function validateForm() {
	var x = document.forms["createSale"];
	if (x["name"].value === "") {
		document.getElementById('error').innerHTML="Please enter name of the product";
		return false;
	}

	if (x["baseBidPrice"].value == 0.0) {
		document.getElementById('error').innerHTML="Please enter base bid price higher than 0.0";
		return false;
	}
}