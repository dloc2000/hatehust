package com.vti.entity;

public class Student implements IStudent {
	private int id;
	private String name;
	private int group;
	
	public Student(String name, int group) {
		super();
		int count = 0;
		this.id = ++count;
		this.name = name;
		this.group = group;
	}
	
	public int getGroup() {
		return group;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", group=" + group + "]";
	}
	@Override
	public void diemDanh() {
		System.out.println(name + "diem danh.");
	}
	@Override
	public void hocBai() {
		System.out.println(name + " đang học bài.");	
	}
	@Override
	public void donWc() {
		System.out.println(name + " Dọn Wc.");
	}
}
