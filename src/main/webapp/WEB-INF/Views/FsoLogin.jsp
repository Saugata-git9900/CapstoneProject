<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fso Login</title>
<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		   <s:url value="/resources/Image" var="Images"/>
		   
		    <style>
		  	.container
            {
               height: auto;
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
                background-image: url("${Images}/bg.jpg");
                /*background-attachment: fixed;*/
                min-height:100%;
                background-position: inherit;
                background-repeat: no-repeat;
                background-size: 100% 100%;
                position: relative;
                padding: 5px;
            }
            
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                border: none;
                background: #f1f1f1;
            }

            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
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
			<h3><span class="label label-default"><u><b>Fso Login</b></u></span></h3><br/>
			<form action="fsoLogin" method="post" class="form-inline" align="center">				
				<input type="text" id="usrname" name="userName" placeholder="Enter Username" required> <br/><br/>
				<input type="password" id="pass" name="password" placeholder="Enter Password" required> <br/><br/>
				<h3 style="color:red; font-size:small; font-weight:bold">${message}</h3>
				<button type="submit" class="btn btn-success">LogIn</button>
			</form>

				

		</div></br></br></br></br>
		</div>
</body>
</html>