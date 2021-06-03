package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class Exercise1 {
	public static void question1() {
		Department dep = new Department();
		dep.name = "bao ve";
		Department dep1 = new Department(0, "ki su");
	}
	public static void question2() {
		Account acc1 = new Account(1, "vti@gmail.com","vti2000" ,"vti","nguyen");
		Position pos1 = new Position();
		Account acc2 = new Account(2, "vti@gmail.com","vti2000" ,"vti","nguyen" , pos1);
		Position pos2 = new Position();
		Account acc3 = new Account(3, "vti@gmail.com","vti2000" ,"vti","nguyen" , pos2, LocalDate.of(2021, 05, 17));

	}
}
