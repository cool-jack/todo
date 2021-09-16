package com.springAnnotations.dao;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springAnnotations.model.Todo;
import com.springAnnotations.model.User;

@Repository
public class SpringOneDaoImpl implements SpringOneDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(User user) {
		System.out.println("in dao");
		sessionFactory.getCurrentSession().save(user);		
		
	}

	@Override
	@Transactional
	public ArrayList<User> showAllUsers() {
		
		ArrayList<User> userList;
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from user");
		userList = (ArrayList<User>) query;
		
		return userList;
	}
	
	@Override
	@Transactional
	public ArrayList<Todo> showUserTodo(String email) {
		System.out.println("in dao showtodo");
		ArrayList<Todo> userList;
		@SuppressWarnings("unchecked")
		TypedQuery<Todo> query = sessionFactory.getCurrentSession().createQuery("from Todo t where t.email=:email");
		query.setParameter("email", email);
		userList =  (ArrayList<Todo>) query.getResultList();
		
		return userList;
	}

	@Override
	@Transactional
	public User getUser(String email) {
		User userBean = new User();
		@SuppressWarnings("unchecked")
		Query<User> query = sessionFactory.getCurrentSession().createQuery("from User u where u.email = :email");
		query.setParameter("email", email);
		userBean =  query.uniqueResult();
		return userBean;
	}

	@Override
	public void deleteUser(int todoId) {
		
		Query<Todo> query;
		
	}

	@Override
	@Transactional
	public Todo retrieveTodo(int todoId) {
		Todo todoBean = new Todo();
		
		@SuppressWarnings("unchecked")
		Query<Todo> query = sessionFactory.getCurrentSession().createQuery("from Todo t where t.todoId=:todoId");
		query.setParameter("todoId", todoId);
		todoBean = query.uniqueResult();
		return todoBean;
	}

	@Override
	@Transactional
	public boolean updateTodo(Todo todoBean) {
		
		//sessionFactory.getCurrentSession().update(todoBean);
		String sql = "update Todo t set t.desc = :desc, t.isDone= :isDone where t.todoId= :todoId";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("desc", todoBean.getDesc());
		query.setParameter("isDone", todoBean.getIsDone());
		query.setParameter("todoId", todoBean.getTodoId());
		int i = query.executeUpdate();
		return true;
	}
	
	@Transactional
	public boolean deleteTodo(Todo todoBean) {
	
		String sql = "delete from Todo t where t.todoId= :todoId";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("todoId", todoBean.getTodoId());
		int i = query.executeUpdate();
		return true;
	}

	@Override
	@Transactional
	public boolean addTodo(Todo todoBean) {
		sessionFactory.getCurrentSession().save(todoBean);
		return true;
	}
	
	

}
