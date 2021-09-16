<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">

<title>Register</title>
</head>
<body>
<p align="center"><font color="red">${message}</font></p>
		<form action="/register" method="post">
			<table align="center">
				<tr>
					<td>First Name</td> <td><input type="text" name="firstName" /> </td>
				</tr>
				<tr>
					<td>Last Name</td> <td><input type="text" name="lastName" /> </td>
				</tr>
				<tr>
					<td>Email</td> <td><input type="text" name="email" /> </td>
				</tr>
				<tr>
					<td>Confirmed Email</td> <td><input type="text" name="confirmedEmail" /> </td>
				</tr>
				<tr>
					<td>Password</td> <td><input type="password" name="password" /> </td>
				</tr>
				<tr>
					<td>Confirmed Email</td> <td><input type="password" name="confirmedPassword" /> </td>
				</tr>
				<tr>
					<td colspan="2" align="center"> <input type="submit" value="Submit"> </td> 
				</tr>
			</table>
		</form>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>