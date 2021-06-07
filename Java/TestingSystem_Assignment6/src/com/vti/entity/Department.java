package com.vti.entity;

public class Department {
	public static int COUNT;
	private int id;
	private String name;

	public Department(String name) {
		super();
		COUNT++;
		this.id = COUNT;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
