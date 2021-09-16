package com.springAnnotations.Controller;

import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springAnnotations.Service.SpringOneServiceImpl;
import com.springAnnotations.model.Todo;
import com.springAnnotations.model.User;

@Controller
@SessionAttributes("userBean")
public class SpringOneController {
	@Autowired
	SpringOneServiceImpl service;
	
	@RequestMapping(value="/login")
	public String SayHello() {
		System.out.println("in get login");
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String validateLogin(@RequestParam String email, @RequestParam String password, ModelMap model) {
		User userbean = null;
		userbean = service.validateCredentialsForLogin(email, password);
		if(userbean == null || !(userbean.getEmail().equals(email) && userbean.getPassword().equals(password))) {
			model.put("message", "invalid credentials");
			return "login";
		}
		
		model.put("userBean", userbean);
		return "redirect:/showUserTodo";
		
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String registerUser(ModelMap model , @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String email, @RequestParam String password) {
		boolean success = true;
		System.out.println("in post register");
		User user = new User(firstName, lastName,email,password);
		success = service.saveUser(user);
		model.put("user", user);
		if(success)	{
			model.put("message", "Registration successful. Please login now using email and password");
			return "login";
			}
		model.put("message", "Registration not successful. user already there");
		return "register";
	}
	
	@RequestMapping(value="/showUserTodo", method = RequestMethod.GET)
	public String showUserTodo(ModelMap model) {
		System.out.println("showUserTodo");
		User user = (User) model.get("userBean"); 
		System.out.println("users email"+user.getEmail());
		ArrayList<Todo> todoList = service.showUserTodo(user.getEmail());
		model.put("todoList", todoList);
		return "home";
	}
	
	
	@RequestMapping(value="/saveUser")
	public void saveUser() {
		System.out.println("in controller");
		User user = new User("jack", "parekh","cooljack1118@gmail.com","jack1118");
		service.saveUser(user);
	}
	
	@RequestMapping(value="/updateTodo", method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int todoId, ModelMap model) {
		Todo todobean = service.retrieveTodo(todoId);
		model.put("todoBean", todobean);
		return "updateTodo";
	}

	@RequestMapping(value="/updateTodo", method = RequestMethod.POST)
	public String updateTodo(@RequestParam int todoId, @RequestParam String desc, @RequestParam String deadline,
			@RequestParam boolean isDone, ModelMap model) throws ParseException {
		System.out.println("in update todo controller");
		Todo todoBean = new Todo();
		todoBean.setTodoId(todoId);
		todoBean.setDesc(desc);
//		todoBean.setDeadline(new SimpleDateFormat("yyyy-MM-dd").parse(deadline));
		todoBean.setIsDone(isDone);
//		model.put("todoBean", todoBean);
		boolean isUpdated = service.updateTodo(todoBean);
		if(isUpdated) return "redirect:/showUserTodo";
		
		return "updateTodo";
	}
	@RequestMapping(value="/deleteTodo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int todoId, ModelMap model) throws ParseException {
		System.out.println("in update todo controller");
		Todo todoBean = new Todo();
		todoBean.setTodoId(todoId);
//		model.put("todoBean", todoBean);
		boolean isUpdated = service.deleteTodo(todoBean);
		if(isUpdated) return "redirect:/showUserTodo";
		
		return "redirect:/showUserTodo";
	}
	
	@RequestMapping(value="/addTodo", method = RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
			
		return "addTodo";
	}
	
	@RequestMapping(value="/addTodo", method = RequestMethod.POST)
	public String addTodo(@RequestParam String desc, @RequestParam String deadline, ModelMap model)  {
		User userBean = (User) model.get("userBean");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate deadlineDate = LocalDate.parse(deadline,formatter);
		java.sql.Date ddDate = java.sql.Date.valueOf(deadlineDate);
		Todo todoBean = new Todo(desc, ddDate, ddDate, false, userBean.getEmail());
		boolean isTodoSaved = service.addTodo(todoBean);
		if(isTodoSaved) return "redirect:/showUserTodo";
		return "redirect:/showUserTodo";
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String addTodoPage(HttpServletRequest request, ModelMap model) {
			HttpSession session = request.getSession();
			session.invalidate();
			model.put("message", "successfully logged out");
		return "login";
	}
	
	
}
