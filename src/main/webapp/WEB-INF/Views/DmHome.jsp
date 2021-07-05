<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DepartmentManagerHomePage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		  <s:url value="/resources/Image" var="Images"/>
		<style>
			.info{
				background-color="yellow";
				font-color="blue";
			}
			
			.container
            {
               height: inherit;
                position:relative;
                left: 23%;
                margin: 20px;
                max-width: 50%;
                padding: 16px;
                text-align: center;
                background-image: url("${Images}/spot-light.jpg");
                background-size: 100% 100%;
                border: solid;
            }
            
            .bg {
                background-image: url("${Images}/vch.jpg");
                background-attachment: fixed;
                min-height:100%;
                background-position: center;
                background-repeat: no-repeat;
                background-size: 100% 100%;
                position: relative;
                padding: 5px;
            }
            
             .logout{
            	text-align:right;
            }
		</style>
</head>
<body>
	 <table border="0" bgcolor="black" align="center" width="100%" style="height:100px">
            <td bgcolor='black' align='center'>
                <font style='font-family: 'Arial Rounded MT Bold', Gadget, sans-serif;' size='+4' color='yellow'>Gen Pharmaceuticals </font><br/>
                <font style='font-family: 'Arial Rounded MT Bold', Gadget, sans-serif;' size='+2' color='blue'>Electronic Vouher System </font>
            	
            	<div class="logout">
         			<p><a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" >LogOut</a> </p>
         		</div>
            </td>
         </table>
         
         <div class="bg">
         <div class="info">
         	<h2 class="bg-warning">Welcome Mr.${sessionScope.name.name} to Electronic Voucher System</h2>
         </div>
         
         <div class="container">
         <h3><u>List of Pending Vouchers</u></h3>
         	<table class="table table-striped">
         		<tr>
         			<th>Voucher Id</th><br/><br/>
         			<th>Employee Name</th><br/><br/>
         			<th>Voucher Type</th><br/><br/>
         			<th>Ammount</th><br/><br/>
         			<th>Status</th><br/><br/>
         			<th></th>
         			
         		</tr>
         		
         		<c:forEach items="${pendingvoucher}" var="v">
         			<tr>
         				<td>${v.voucherId }</td>
         				<td>${v.employee.empName }</td>
         				<td>${v.name}</td>
         				<td>${v.ammount}</td>
         				<td>${v.status}</td>
         				
         				<td><a class="btn btn-success" href="${pageContext.request.contextPath}/dmSetStatus${v.voucherId}">View Details</a></td>
         			</tr>
         		</c:forEach>
         	</table>
         </div>
         </div>
</body>
</html>