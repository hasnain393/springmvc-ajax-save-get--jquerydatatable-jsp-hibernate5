<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>CRM - Customer Relationship Manager</h2>
			<hr />
			<label>Choose a page size:</label> <select id="psize" name="pgsize">
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
			<button id="pageBtn" class="btn btn-primary">get paged
				records</button>
			<table id="res" class="table table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link with customer id -->
					<c:url var="page0Link" value="/customer/page">
						<c:param name="pgnum" value="0" />
						<c:param name="pgsize" value="4" />
					</c:url>

					<c:url var="page1Link" value="/customer/page">
						<c:param name="pgnum" value="1" />
						<c:param name="pgsize" value="4" />
					</c:url>

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/updateForm">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>


					<tr>
						<td>${tempCustomer.id}</td>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>

						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>

			<div class="text-center">
				<a href="${page0Link}">0</a> <a href="${page1Link}">1</a>
			</div>

			</table>
		</div>
	</div>
	
	<div>
	
	<h3>${totol}</h3>

	<table id="sir" class="table table-striped table-bordered">
				<tr>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					
				</tr>
				</table>
				
				<div id="link"></div>
				
				</div>

	<script type="text/javascript">
		$("#pageBtn")
				.click(
						function() {
							var contentToRemove = document.querySelectorAll("#div1");
							$(contentToRemove).remove();
							/* $('#div1').each(function() {
							    $(this).remove();
							}); */
						//	$("#div1").remove();
							alert("button pressed");
							alert($("#psize").val());
							alert($("h3").text());
							var per=$("h3").text();
							var size = $("#psize").val();
							var url1 = "http://localhost:8081/springmvc5-hibernate5-jsp-mysql-example/customer/pageajax?pgnum=0&pgsize=";
							var url2 = size;
							var url3 = url1 + url2;
							var tt=per/size;
							alert(tt);
							alert(url3);
							for (i = 0; i < tt; i++) {
							    $('<a class="drum" href=' + url3 + ' >' + i + '</a>').appendTo('#link');
							    
							    
							  }
							$.ajax({
								type : "get",
								url : url3,
								success : function(data) {
									console.log("data received" + data);
									var list = JSON.stringify(data);

									var f_name = data[0].firstName;

									//alert(f_name);
									console.log("list" + list)
									//alert("daaaata"+data);
									//  alert("in list"+list);
									$.each(data, function(index, value) {
										
										$("#sir").append(
												"<tr id='div1'>" + "<td>"
														+ data[index].firstName
														+ " </td>" + "<td>"
														+ data[index].lastName
														+ " </td>" + "<td>"
														+ data[index].email
														+ " </td>" 
														+ "</tr>");
									})
								},
								error : function() {
									alert('Error while request..');
								}
							})

						})
			

			$("a.drum").click(function() {
				  alert( "Handler for .click() called." );
			});
	</script>
</body>
</html>