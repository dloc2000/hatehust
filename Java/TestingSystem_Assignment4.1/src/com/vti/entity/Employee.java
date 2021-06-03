package com.vti.entity;

public class Employee extends Staff {
	private String job;

	public Employee(String name, int age, Gender gender, String address, String job) {
		super(name, age, gender, address);
		this.job = job;
	}

	@Override
	public String toString() {
		return super.toString()+ "Employee [job=" + job + "]";
	}

}
