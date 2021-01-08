<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>javaguides.net</title>
 

 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

jQuery library
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>CRM - Customer Relationship Manager</h2>
			<hr />





			<input type="button" value="Add Customer"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br>
			<form action="sortby" method="get">

				<button class="btn btn-primary" style="float: right;">Ascending
					button</button>
			</form>


			<h3>total number of records are : ${totalcount}</h3>
			<!--  working link 
     <a href="/springmvc5-hibernate5-jsp-mysql-example/customer/sortby">Ascending</a>
  	 -->

			<a href="/springmvc5-hibernate5-jsp-mysql-example/customer/excel">
				<button class="btn btn-primary">export to EXCEL</button>
			</a> <a href="/springmvc5-hibernate5-jsp-mysql-example/customer/pdf">
				<button class="btn btn-primary">export to PDF</button>
			</a> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Customer List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
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




				</div>
			</div>
		</div>

	</div>
	
	
	<form action="mail" method="get" class="text-center"
		style=" width:30%;margin-left: 40%">
		<div class="form-group">
			<label>Enter your email:</label>
			<input name="mailto" placeholder="enter your gmail" class="form-control" />
		</div>


		<button class="btn btn-primary form-control" onclick="myFunction()">send
			mail</button>

	</form>

	<script>
     function myFunction(){
    	 alert("mail is sent ");
     }</script>
</body>
</html>