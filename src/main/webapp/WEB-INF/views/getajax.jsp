<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>test</title>
<!-- integrate jquery using cdn  -->
<!-- <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>  -->

<!-- or  using jstl c tags-->
<%-- <script src="<c:url value="/resource123/js/jquery-3.5.1.min.js" />"></script> --%>
<!-- or  using spring tag -->
<spring:url var="jqueryJs" value="/resource123/js/jquery-3.5.1.min.js" />
<script src="${jqueryJs}"></script>
<link rel="stylesheet"
	href="<c:url value="/resource123/css/bootstrap.min.css" />">
</head>
<body>
	<h1>testing ajax calll</h1>
	<button id="timeBtn" class="btn btn-primary">get time</button>
	<p id="time"></p>

	<h1>Spring Framework Jquery Ajax Demo</h1>
	<div id="result">
		<div class='panel-body'>
			<table id="res" class='table table-striped table-bordered'>
				<tr>
					<th>First Name</th>"
					<th>Last Name</th>
					<th>Email</th>
					
				</tr>
				
			</table>
		</div>
	</div>
	<script>

/* $(document).ready(function(){
	//alert("heloo jquery integret jquery using spring tag jquery_lib");
	$("#timeBtn").click(function(){
		//alert("buttoned clicked");
		$.ajax({
			url:"getServerTime",
			success:function(data){
				$("#time").html(data);
			}
		})
	})
}); */

$("#timeBtn").click(function(){
$.ajax({
    type: "get",
    url: "http://localhost:8081/springmvc5-hibernate5-jsp-mysql-example/customer/ajaxget",
   // cache: false,    
    //data:'firstName=' + $("#firstName").val() + "&lastName;=" + $("#lastName").val() + "&email;=" + $("#email").val(),
    success: function(data){
    	console.log("data received"+data);
    	var list= JSON.stringify(data);
     
     var f_name=data[0].firstName;
     
     //alert(f_name);
     console.log("list"+list)
     //alert("daaaata"+data);
   //  alert("in list"+list);
     $.each(data, function( index, value ) {
     $("#res")
		.append(
					"<tr>"
						+"<td>"
						+ data[index].firstName
						+ " </td>"
						+ "<td>"	
						+ data[index].lastName
						+ " </td>"
						+ "<td>"
						+ data[index].email
						+ " </td>"
						+"</tr>"
						);
     })
    },
    error: function(){      
     alert('Error while request..');
    }
   });
});

</script>
</body>
</html>