package com.springAnnotations.Service;

import java.util.ArrayList;

import com.springAnnotations.model.Todo;
import com.springAnnotations.model.User;

public interface SpringOneService {
	
	boolean validateCredentials(String name, String password);
	User validateCredentialsForLogin(String email, String password);
	boolean saveUser(User user);
	ArrayList<User> showAllUsers();
	ArrayList<Todo> showUserTodo(String email);
	boolean deleteTodo(int todoId);
	Todo retrieveTodo(int todoId);
	boolean updateTodo(Todo todoBean);
	boolean deleteTodo(Todo todoBean);
	boolean addTodo(Todo todoBean);
}
