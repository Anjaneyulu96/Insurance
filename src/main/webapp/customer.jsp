<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text] {
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
<script type="text/javascript" src="/js/validate.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="/style/jquery-ui.css" />
</head>
<body>
<h2 align="center">Customer</h2>
<div class="container" id='error'></div>
<div class="container">
  <form:form id="formId" action="/customer/success" method="post" modelAttribute="customer">
    <label for="firstName">First Name</label>
    <form:input type="text" id="firstName" path="firstName" placeholder="Your name.." required="true"/>
<br/>
    <label for="lastName">Last Name</label>
    <form:input type="text" id="lastName" path="lastName" placeholder="Your last name.." required="true"/>
<br/>    
    <label for="address">Address</label>
    <form:input type="text" id="address" path="address" placeholder="Your address.." required="true"/>
<br/>
    <label style="width: 50%" for="city"><b>City : </b></label>
    <form:label  id="city" path="city">${customer.city}</form:label>
    <br/> 
    <label style="width: 50%" for="state"><b>State : </b></label>
    <form:label  id="state" path="state">${customer.state}</form:label>
<br/>    
    <label for="zip"><b>Zip</b></label>
    <form:input type="text" id="zip" path="zip" value="${customer.zip}" 
    	placeholder="Your zip.." onchange="onchangeZip('/customer/onchange');" 
    	onkeypress="return validateFloat(event,this)" maxlength="5" required="true"/>
<br/>
    <label for="dob">DOB</label>
    <form:input id="dateId" path="dob" value="${customer.dob}" placeholder="Your DOB.." required="true"/>
<br/>
    <input type="submit" value="Next">
  </form:form>
</div>
</body>
</html>