package com.springAnnotations.dao;

import java.util.ArrayList;

import com.springAnnotations.model.Todo;
import com.springAnnotations.model.User;

public interface SpringOneDao {
	
	void save(User user);
	ArrayList<User> showAllUsers();
	ArrayList<Todo> showUserTodo(String email);
	User getUser(String email);
	void deleteUser(int todoId);
	Todo retrieveTodo(int todoId);
	boolean updateTodo(Todo todoBean);
	boolean deleteTodo(Todo todoBean);
	boolean addTodo(Todo todoBean);
}
