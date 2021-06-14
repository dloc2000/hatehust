package com.vti.entity;

import com.vti.ultis.ScannerUltis;

public class Student {
	private int id;
	private String name;
	public static int moneyGroup;
	public static String collect = "Đại học Bách Khoa";
	private static int COUNT = 0;
	public Student() {
		super();
		this.id = ++COUNT;
		System.out.println("Nhập vào tên sinh viên : ");
		this.name = ScannerUltis.inputString();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + " ,collect: " + collect +  "]";
	}
	

	
}
