<%@page isELIgnored="false" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<title>Home Page</title>
		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		  <s:url value="/resources/Image" var="Images"/>
		  
		  <style>
			
			.container
            {
               height: inherit;
                position:relative;
                left: 23%;
                margin: 20px;
                max-width: 50%;
                padding: 16px;
                text-align: center;
                background-color: teal;
                background-size: 100% 100%;
                background-image: url("${Images}/bgImg.jpg");
                border: solid;
            }
            
            .bg {
                background-image: url("${Images}/Img.jpg");
                background-attachment: fixed;
                min-height:100%;
                background-position: center;
                background-repeat: no-repeat;
                background-size: 100% 100%;
                position: relative;
                padding: 5px;
            }
            
             .column1
            {
                float: bottom;
                width: 80%;
                padding-left:10%;
               /* padding-right: 5%;
                padding-top: 5%;
                padding-bottom: 10%;*/
                text-align: justify;
                font-size: 16pt;
                font-style:italic;
                height: 80%;
                opacity:1;
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
		<div class="container" align="center">
			<h3><span class="label label-default"><u><b>Choose Designation</b></u></span></h3> </br>
			<p><a href="${pageContext.request.contextPath}/empLogin" class="btn btn-info" >Employee</a> </p>
			<p><a href="${pageContext.request.contextPath}/dmLogin" class="btn btn-info" >Departmental Manager</a> </p>
			<p><a href="${pageContext.request.contextPath}/fsoLogin" class="btn btn-info" >Financial Services Oficer </a></p> 		
		</div></br></br></br></br>
		
		<div class="column1" align="center-left">
			<h4 class= "bg-info"><b><u>About Us</u></b></h4>
			<p class="bg-info">
				A voucher is a bond of the redeemable transaction type which is worth a certain monetary value 
				and which may be spent only for specific reasons or on specific goods.
				Examples include housing, travel, and food vouchers. The term voucher is also a synonym for receipt
				and is often used to refer to receipts used as evidence of, for example, the declaration that a 
				service has been performed or that an expenditure has been made. Voucher is a tourist guide for 
				using services with a guarantee of payment by the agency.
			</p>
		</div>
		</div>
</body>
</html>
