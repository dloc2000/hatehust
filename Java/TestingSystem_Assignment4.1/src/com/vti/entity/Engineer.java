package com.vti.entity;

public class Engineer extends Staff {
	private String Specialized;
	public Engineer(String name, int age, Gender gender, String address ,String Specialized) {
		super(name, age, gender, address);
		this.Specialized = Specialized;
	}
	@Override
	public String toString() {
		return super.toString() + "Engineer [Specialized=" + Specialized + "]";
	}

}
