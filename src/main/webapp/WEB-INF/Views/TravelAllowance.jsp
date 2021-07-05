<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TravelAllowance</title>
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
                background-image: url("${Images}/blue_background.jpg");
                background-size: 100% 100%;
                border: solid;
            }
            
            .bg {
                background-image: url("${Images}/acc.jpg");
                background-attachment: fixed;
                min-height:100%;
                background-position: center;
                background-repeat: no-repeat;
                background-size: 100% 100%;
                position: relative;
                padding: 5px;
            }
            
            label { float: left; width: 9em; margin-right: 1em; }
            
             input[type=text], input[type=date], input[type=number] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                border: none;
                background: white;
            }
            
             input[type=text]:focus, input[type=date]:focus, input[type=number]:focus{
             	background-color: #ddd;
                outline: none;
             }
             
             .btn
            {
                background-color: green;
                color: whitesmoke;
                padding: 16px 20px;
                border: solid;
                cursor: pointer;
                width: 100%;
                opacity: 1;
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
		  <h2 style="font-family: bold;text-align: center"><u>Travel Allowance Submission Form</u></h2><br/>
		  	<hr>
		  	<form action="addTravel" method="post" class="form-inline" align="center">
		  	
		  		<label for="place"><b>Place:</b></label>
		  		<input type="text" id="place" name="place" placeholder="Enter Travel Place" required> <br/><br/>
		  		<label for="mode"><b>Travel Mode:</b></label>
				<input type="text" id="mode" name="mode" placeholder="Enter Travel Mode" required> <br/><br/>
				<label for="date"><b>Travel Date:</b></label>
				<input type="date" id="date" name="date" placeholder="Enter Travel Date" required> <br/><br/>
				<h5 style="color:red; font-weight:bold">${errordate}</h5>
				<label for="amt"><b>Voucher Ammount:</b></label>
				<input type="number" id="amt" name="amt" placeholder="Enter Voucher Ammount" required> <br/><br/>
				<label for="reason"><b>Reason for submitting voucher</b></label>
				<textarea name="reason" rows="4" cols="50"></textarea>
				<h3 style="color:red; font-weight:bold">${Errormessage}</h3>
				<button type="submit" align="center" class="btn">Submit</button>
		  	</form>
	
		  </div>
		  </div>
</body>
</html>