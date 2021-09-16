package com.springAnnotations.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springAnnotations.dao.SpringOneDao;
import com.springAnnotations.dao.SpringOneDaoImpl;
import com.springAnnotations.model.Todo;
import com.springAnnotations.model.User;

@Service
public class SpringOneServiceImpl implements SpringOneService {
	
	@Autowired
	private SpringOneDao dao;
	
	
	public boolean validateCredentials(String name, String password) {
		
		return name.equals("dhruv") && password.equals("jacku");
		
		
	}
	
	public User validateCredentialsForLogin(String email, String password) {
		
		User userBean = null;
		userBean  = dao.getUser(email);
		if(userBean == null) return null; 
		return userBean;
	}

	@Override
	public boolean saveUser(User user) {
		System.out.println("in service"+user.getEmail());
		boolean isThere = false;
		User userBean = dao.getUser(user.getEmail());
		if(userBean == null) { 
			dao.save(user);
			isThere = true;
		}
		return isThere;
	}

	@Override
	public ArrayList<User> showAllUsers() {
		ArrayList<User> userList = dao.showAllUsers();
		return userList;
	}
	
	@Override
	public ArrayList<Todo> showUserTodo(String email) {
		
		System.out.println("in service showtodo");
		
		ArrayList<Todo> userList = dao.showUserTodo(email);
		return userList;
	}

	@Override
	public boolean deleteTodo(int todoId) {
		boolean isDeleted = true;
		
		dao.deleteUser(todoId);
		
		return false;
	}

	@Override
	public Todo retrieveTodo(int todoId) {
		Todo todoBean = new Todo();
		todoBean = dao.retrieveTodo(todoId);
		return todoBean;
		
	}

	@Override
	public boolean updateTodo(Todo todoBean) {
		
		dao.updateTodo(todoBean);
		return true;
	}

	@Override
	public boolean deleteTodo(Todo todoBean) {
		dao.deleteTodo(todoBean);
		return true;
	}

	@Override
	public boolean addTodo(Todo todoBean) {
		
		dao.addTodo(todoBean);
		
		return true;
	}

}
