<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>medicalStatusPage</title>
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
                min-height:100%;
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
         			<th>Nature of Illness</th><br/><br/>
         			<th>Date of Illness</th><br/><br/>
         			<th></th>
         			<th></th>
         		</tr>
         		
 
         			<tr>
         				<td>${medicalStatus.nature }</td>
         				<td>${medicalStatus.date }</td>

         			</tr>

         	</table>
         	<h5 style="font-weight: bold">Reason for voucher enrollment:</h5>
         	<p>${medicalStatus.reason }</p>
         	
         	
         				<a class="btn btn-primary" href="${pageContext.request.contextPath}/finalStatus${medicalStatus.voucherId}/Submitted">Submitted</a>
						<a class="btn btn-warning" href="${pageContext.request.contextPath}/finalStatus${medicalStatus.voucherId}/Approved (by FSO)">Approve</a>
						<a class="btn btn-success" href="${pageContext.request.contextPath}/finalStatus${medicalStatus.voucherId}/Paid">Paid</a>
						
						<form action="${pageContext.request.contextPath}/finalStatus${medicalStatus.voucherId}/Rejected (by FSO)">
							<div>
								<textarea name="remarks" rows="4" cols="50" placeholder="REMARKS only for REJECTED voucher"></textarea><br/>
								<button type="submit" align="center" class="btn btn-danger">Reject</button>
							</div>
						</form>
						
						
						
						
         	<p><a href="${pageContext.request.contextPath}/logout" class="btn btn-danger" >LogOut</a> </p>
         </div>
         </div>
</body>
</html>