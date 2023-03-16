<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, label {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<h2 align="center">Driver</h2>
<div class="container">
	<form action="/driver/success">
		<div class="container">
		    <label for="firstName">First Name</label>
		    <input type="text" id="firstName" name="firstName" placeholder="Your name.." required/>
		<br/>
		    <label for="lastName">Last Name</label>
		    <input type="text" id="lastName" name="lastName" placeholder="Your last name.." required/>
		<br/> 
		<input type="submit" value="Next">
		</div>
	</form>
</div>
</body>
</html>