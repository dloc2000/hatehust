package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String homeTown;
	private int point;

	public Student(int id, String name, String homeTown, int point) {
		super();
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
		this.point = 0;
	}

	public void plusPoint(int point) {
		this.point = this.point + point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		String rank = null;
		if(this.point < 4){
			rank = "Yếu";
		}
		else if(this.point < 6){
			rank = "Trung Bình";
		}
		else if(this.point < 8){
			rank = "Khá";
		}
		else {
			rank = "Giỏi";
		}
		return "Student [name=" + name + ", point=" + point + "Xếp loại :" + rank + "]";
	}

}
