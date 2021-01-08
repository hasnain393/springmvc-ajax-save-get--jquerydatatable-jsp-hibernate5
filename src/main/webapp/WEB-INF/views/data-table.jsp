<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
 			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
            <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <link rel="stylesheet" href="https://cdn.datatables.net/1.10.23/css/dataTables.jqueryui.min.css">
            <link rel="stylesheet" href="https://cdn.datatables.net/scroller/2.0.3/css/scroller.jqueryui.min.css">
</head>  
<body>  
    <br /><br />  
    <div class="container">  
         <h1 align="center">Show JSON Data in Jquery Datatables</h3><br />  
         <h3 align="center">Employee Database</h3><br />  
         <table id="data-table" class="table table-bordered">  
              <thead>  
                   <tr>  
                        <th>FirstName</th>  
                        <th>Last Name</th>  
                        <th>Email</th>  
                   </tr>  
                   
              </thead>
              <tbody> 
              <c:forEach var="tempCustomer" items="${customers}">
              <tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>

							</tr>
              </c:forEach>
              </tbody> 
         </table>  
    </div>  
     <script src="https://code.jquery.com/jquery-3.5.1.js"></script>  
              <script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script> 
              <script src="https://cdn.datatables.net/1.10.23/js/dataTables.jqueryui.min.js"></script>  
              <script src="https://cdn.datatables.net/scroller/2.0.3/js/dataTables.scroller.min.js"></script>
              <script>  
$(document).ready(function(){  
$('#data-table').DataTable({  
    
});  
});  
</script>
</body>  
</html>  
  