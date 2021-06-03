package com.vti.entity;

public class HighSchoolStudent extends Student {
private String clazz;
private String desiredUniversity;

	public HighSchoolStudent(int id, String name, String clazz, String desiredUniversity) {
	super(name, id);
	this.clazz = clazz;
	this.desiredUniversity = desiredUniversity;
}

	@Override
	public String toString() {
		return super.toString()+ "HighSchoolStudent [clazz=" + clazz + ", desiredUniversity=" + desiredUniversity + "]";
	}

}
