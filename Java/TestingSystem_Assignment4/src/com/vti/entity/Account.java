package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;
	public Account() {
		super();
	}

	public Account(int id, String email, String userName, String firstName, String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + lastName;
	}

	public Account(int id, String email, String userName, String firstName, String lastName, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	public Account(int id, String email, String userName, String firstName, String lastName,Position position,
			LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	
	public Account(int id, String email, String userName, String fullName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
	}

	public Account(int id, String email, String userName, String fullName, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
	}

	

	public Account(int id, String email, String userName, String fullName, Position position, LocalDate createDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.position = position;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}

	


