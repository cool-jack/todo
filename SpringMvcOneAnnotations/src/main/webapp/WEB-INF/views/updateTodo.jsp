<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updateTodo</title>
</head>
<body>

<form method="post">
<input type="hidden" name="todoId" value="${todoBean.todoId}">
	<table align="center">
		<thead>
			<tr>
				<td colspan="2" align="center">Update Todo</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Description</td><td><input type="text" name="desc" value="${todoBean.desc}"></td>
			</tr>
			<tr>
				<td>Deadline</td><td><input type="text" name="deadline" value="${todoBean.deadline}"></td>
			</tr>
			<tr>
				<td>Finished</td><td><input type="text" name="isDone" value="${todoBean.isDone}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Update Todo"> <button href="/showUserTodo" class="button" > Back </button></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>