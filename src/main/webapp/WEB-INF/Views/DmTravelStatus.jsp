<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dm travelStatus</title>
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
                background-image: url("${Images}/bg.jpg");
                background-attachment: fixed;
                height:100%;
                background-position: center;
                background-repeat: no-repeat;
                background-size: 100% 100%;
                position: relative;
                padding: 5px;
            }
		</style>
</head>
<body>
	<table border="0" bgcolor="black" align="center" width="100%" style="height:100px">
            <td bgcolor='black' align='center'>
                <font style='font-family: 'Arial Rounded MT Bold', Gadget, sans-serif;' size='+4' color='yellow'>Gen Pharmaceuticals </font><br/>
                <font style='font-family: 'Arial Rounded MT Bold', Gadget, sans-serif;' size='+2' color='blue'>Electronic Vouher System </font>
            </td>
         </table>
		
		<div class="bg">
          <div class="container">
         
         	<table class="table table-striped">
         		<tr>
         			<th>Place:</th><br/><br/>
         			<th>Mode:</th><br/><br/>
         			<th>Date:</th><br/><br/>
         			<th></th>
         			<th></th>
         		</tr>
         		
 
         			<tr>
         				<td>${travelSetStatus.place }</td>
         				<td>${travelSetStatus.mode }</td>
         				<td>${travelSetStatus.date }</td>

         			</tr>

         	</table>
         	<h5 style="font-weight: bold">Reason for submitting voucher:</h5>
         	<p>${travelSetStatus.reason }</p>
         	
         				<a class="btn btn-success" href="${pageContext.request.contextPath}/statusupdate${travelSetStatus.voucherId}/Approved (by DM)">Approve</a>
						<a class="btn btn-warning" href="${pageContext.request.contextPath}/statusupdate${travelSetStatus.voucherId}/Rejected (by DM)">Reject</a>

         	<p><a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" >LogOut</a> </p>
         </div>
         </div>
</body>
</html>