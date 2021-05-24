package com.vti.frontend;

import com.vti.entity.Account;

public class Demo4 {
//	Exercise 6 (Optional): Method
//	Question 1:Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	private static void ques1
	{
		for (int i = 2; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

//	Question 2:Tạo method để in thông tin các account
	private static void ques2(Account account) {
		System.out.println("ID: " + account.id + " Email: " + account.email + " Username: " + account.userName
				+ " FullName: " + account.fullName + " CreareDate: " + account.createDate);
	}

//	Question 3:Tạo method để in ra các số nguyên dương nhỏ hơn 10
    private static void ques3
	{
		for (int j = 1; j < 10; j++) {
			System.out.println(j);
		}
	}
}
