<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="center"><a href="/addTodo"> Add Todo </a><a href="/logout">Logout</a> </p>
	<table align="center">
		<thead>
			<tr>
			<th>Description</th>
			<th>Date</th>
			<th>Completed</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todoList}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td>${todo.deadline}</td>
				<td>${todo.isDone}</td>
				<td><a href="/deleteTodo?todoId=${todo.todoId}" >delete</a> <a href="/updateTodo?todoId=${todo.todoId}" >update</a> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>