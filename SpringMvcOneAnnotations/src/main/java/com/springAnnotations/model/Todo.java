package com.springAnnotations.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "todo")
public class Todo {
	
	@Id
	@GeneratedValue
	@Column(name = "todo_id")
	private int todoId;
	
	@Column(name="todo_desc")
	private String desc;
	
	@Column(name="date")
	private Date date;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@Column(name="isDone")
	private Boolean isDone;
	
	@Column(name = "email")
	private String email;
	
	
	
	public Todo() {}
	
	public Todo(String desc,  Date date, Date deadline, Boolean isDone, String email) {
		super();
		this.desc = desc;
		this.date = date;
		this.deadline = deadline;
		this.isDone = isDone;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	
	

}
