<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>medicalTrackStatusPage</title>
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
               width:auto;
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
                height: auto;
                background-position: center;
                background-repeat: inherit;
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
         			<th><span style="font-weight: bolder; text-align: right; font-size: 18px">STATUS</span></th><br/><br/>
         			<th><span style="font-weight: bolder; text-align: right; font-size: 18px">
         				<c:set var="med" value="${medicalStatus.status }"/>
				         	<c:set var="status" value="Rejected (by FSO)"/>

							<c:if test="${med==status}">
         						<c:out value= "REMARKS" />
         					</c:if>
         			</span></th>
         			<th></th>
         		</tr>
         		
 
         			<tr>
         				<td>${medicalStatus.nature }</td>
         				<td>${medicalStatus.date }</td>
         				<td><span style="font-weight: bolder; text-align: right; font-size: 16px">${medicalStatus.status }</span></td>
						<td><span style="font-weight: bolder; text-align: right; font-size: 16px">
							<c:set var="med" value="${medicalStatus.status }"/>
				         	<c:set var="status" value="Rejected (by FSO)"/>
				         	<c:set var="remarks" value="${medicalStatus.remarks}"/>
							
							<c:if test="${med==status}">
         						<c:out value= "${medicalStatus.remarks}" />
         					</c:if>
						</td>
         			</tr>

         	</table>
         				
         </div>
         </div>
</body>
</html>