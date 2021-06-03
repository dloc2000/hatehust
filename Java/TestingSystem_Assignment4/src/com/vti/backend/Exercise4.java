package com.vti.backend;

import com.vti.entity.Student;

public class Exercise4 {
	public void printStudent() {
		Student st1 = new Student(1, "name1", "H1", 0);
		st1.plusPoint(1);
		Student st2 = new Student(2, "name2", "H2", 0);
		st2.plusPoint(5);
		Student st3 = new Student(3, "name3", "H3", 0);
		st3.plusPoint(9);
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
	}
}
