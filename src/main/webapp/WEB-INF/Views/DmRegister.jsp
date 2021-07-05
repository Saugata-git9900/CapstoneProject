<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DepartmentManagerRegister</title>
<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		  
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
                background-color: threedlightshadow;
                background-size: 100% 100%;
                border: solid;
            }
            
            label { float: left; width: 9em; margin-right: 1em; }
            
             input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                border: none;
                background: white;
            }
            
             input[type=text]:focus, input[type=password]:focus{
             	background-color: #ddd;
                outline: none;
             }
             
             .btn
            {
                background-color: blue;
                color: whitesmoke;
                padding: 16px 20px;
                border: solid;
                cursor: pointer;
                width: 60%;
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
		<div class="container">
		  <h2 style="font-family: bold;text-align: center"><u>DepartmentManager Registration Form</u></h2><br/>
		  	<hr>
		  	<form action="managerReg" method="post" class="form-inline" align="center">
		  	
		  		<label for="userName"><b>UserName:</b></label>
		  		<input type="text" id="name" name="userName" placeholder="Enter Username" required> <br/><br/>
		  		<label for="password"><b>Password:</b></label>
				<input type="password" id="pass" name="password" placeholder="Enter Password" required> <br/><br/>
				<label for="dept"><b>Department Name:</b></label>
				<input type="text" id="dept" name="dept" placeholder="Enter Department Name" required> <br/><br/>
				<h3 style="color:red; font-weight:bold">${Errormessage}</h3>
				<button type="submit" align="center" class="btn">SignUp</button>
		  	</form>
	
		  </div>
</body>
</html>