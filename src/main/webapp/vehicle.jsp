<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript" src="/js/validate.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="/js/jquery-ui-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="/style/jquery-ui.css" />
<script type="text/javascript">
            $(document).ready(function () {
                $.ajax({
                    url: "/vehicle/action",
                    method: "GET",
                    data: {operation: 'country'},
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#country').append('<option value="' + value.id + '">' + value.name + '</option>')
                        });
                        $('select').formSelect();
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        $('#country').append('<option>Country Unavailable</option>');
                    },
                    cache: false
                });


                $('#country').change(function () {
                    $('#state').find('option').remove();
                    $('#state').append('<option>Select State</option>'); 
                    $('#city').find('option').remove();
                    $('#city').append('<option>Select City</option>');

                    let cid = $('#country').val();
                    let data = {
                        operation: "state",
                        id: cid
                    };

                    $.ajax({
                        url: "/vehicle/action",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#state').append('<option value="' + value.id + '">' + value.name + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#state').append('<option>State Unavailable</option>');
                        },
                        cache: false
                    });
                });
                
                $('#state').change(function () {
                    $('#city').find('option').remove();
                    $('#city').append('<option>Select City</option>');

                    let sid = $('#state').val();
                    let data = {
                        operation: "city",
                        id: sid
                    };

                    $.ajax({
                        url: "/vehicle/action",
                        method: "GET",
                        data: data,
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            let obj = $.parseJSON(data);
                            $.each(obj, function (key, value) {
                                $('#city').append('<option value="' + value.id + '">' + value.name + '</option>')
                            });
                            $('select').formSelect();
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            $('#city').append('<option>City Unavailable</option>');
                        },
                        cache: false
                    });
                });

            });
        </script>
</head>
<h2 align="center">Vehicle</h2>
<div class="container">
	<form action="/vehicle/success" method="post">
		<div class="input-field">
			<select id="country">
				<option>Select Country</option>
			</select>
		</div>
		<div class="input-field">
			<select id="state">
				<option>Select State</option>
			</select>
		</div>
		<div class="input-field">
			<select id="city">
				<option>Select City</option>
			</select>
		</div>
		<br /> <input type="submit" value="Next">
	</form>
</div>
</body>
</html>