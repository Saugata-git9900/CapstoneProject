<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cashTrackStatus</title>
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
                max-width: 60%;
                padding: 16px;
                padding-right: 20px;
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
         			<th>Reipent Name:</th><br/><br/>
         			<th>Date:</th><br/><br/>
         			<th><span style="font-weight: bolder; text-align: right; font-size: 18px">STATUS</span></th><br/><br/>
         			<th><span style="font-weight: bolder; text-align: right; font-size: 18px">
         				<c:set var="cash" value="${cashStatus.status }"/>
         					<c:set var="status" value="Rejected (by FSO)"/>
         					
         					<c:if test="${cash==status}">
         						<c:out value= "REMARKS" />
         					</c:if>
         			</span></th>
         			
         		</tr>
         		
 
         			<tr>
         				<td>${cashStatus.recipent }</td>
         				<td>${cashStatus.date }</td>
         				<td><span style="font-weight: bolder; text-align: right; font-size: 16px">${cashStatus.status }</span></td>
         				<td><span style="font-weight: bolder; text-align: right; font-size: 16px">
         					<c:set var="cash" value="${cashStatus.status }"/>
         					<c:set var="status" value="Rejected (by FSO)"/>
         					<c:set var="remarks" value="${cashStatus.remarks}"/>
         					
         					<c:if test="${cash==status}">
         						<c:out value= "${cashStatus.remarks}" />
         					</c:if>
         				</span></td>

         			</tr>

         	</table>
         	<%--<c:set var="cash" value="${cashStatus.status }"/>
         	<c:set var="status" value="Rejected (by FSO)"/>
         	<c:set var="remarks" value="${cashStatus.remarks}"/>
         	
         	 <c:if test="${cash==status}">
         		<c:out value="Remarks:" />
         		<c:out value= "${cashStatus.remarks}" />
         	</c:if>--%>
         	
         				
						
         </div>
         </div>
</body>
</html>