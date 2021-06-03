package com.vti.entity;

public abstract class Student extends Person{
	public Student(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private int id;

	public Student(String name, int id) {
		super(name);
		this.id = id;
	}
	
	
	

}
