<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insurance for you</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], select {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 20px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 30%;
}

button:hover {
	opacity: 0.8;
}

.container {
	padding: 16px;
}
</style>
<script type="text/javascript" src="/js/validate.js"></script>
</head>
<body>
	<h1 align="center">Insurance</h1>
	<form action="customer/get" method="get">
		<div align="center" class="container">
		<label><b>Type</b></label> 
				<select style="align-content: center" name="type" id="type">
					<option value="auto">Auto</option>
					<option value="health">Health</option>
					<option value="mortgage">Mortgage</option>
				</select>
			<br/> 
			<label><b>Zip</b></label> 
			<input type="text" onkeypress="return validateFloat(event,this)" maxlength="5"
				placeholder="Enter Zipcode" name="zip" required>
			<br/> 
			<button type="submit">Get A Quote</button>
		</div>
	</form>

</body>
</html>