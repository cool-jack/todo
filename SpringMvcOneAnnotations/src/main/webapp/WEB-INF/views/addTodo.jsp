<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Todo</title>
</head>
<body>

<form method="post">
	<table align="center">
		<thead>
			<tr>
				<td colspan="2" align="center">Add Todo</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Description</td><td><input type="text" name="desc"></td>
			</tr>
			<tr>
				<td>Deadline</td><td><input type="date" name="deadline"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Add Todo"> </td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>