<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Retailer</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function validateform() {
		
		
		$("#addRetailer").click(function(evt) {
			evt.preventDefault();
			var obj = {
					firstName : $("#fname").val(),
					lastName : $("#lname").val(),
				email : $("#email").val(),
							}
			alert(obj.firstName);
			alert(obj.lastName);
			alert(obj.email);
			
			$.ajax({
				url : 'addCustomer.lti',
				method : 'POST',
				data : JSON.stringify(obj),
				
				contentType : 'application/json',
				success : function(response) {
					alert("resone"+response);
					alert("Retailer added");
					location.reload();
				}
			})
		})
	})
</script>
</head>
<body>
	
	<div class="head">Add Customer</div>
	<div>
		<div id="myForm">
			<form class="form-container" id="top" onsubmit="return validateform()">



				<label for="fName"><b id="form-input">Customer firstName</b></label>
				 <input type="text" placeholder="Enter Name" name="fname" id="fname" required>
					 
					 <label for="lName"><b id="form-input">Customer lastName</b></label>
				 <input type="text" placeholder="Enter Name" name="lname" id="lname" required>
					 <label for="Email"><b id="form-input">Customer Email</b></label> 
					 <input type="email" placeholder="Enter Email" name="email" id="email" required>

				 

				<button formaction="#" type="submit" class="btn" id="addRetailer">Done</button>
				<!-- <a href="adminprofile.html">Back</a> -->
			</form>
		</div>
		</div>
</body>
</html>