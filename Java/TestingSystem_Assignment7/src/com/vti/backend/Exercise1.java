package com.vti.backend;

import com.vti.entity.Student;

public class Exercise1 {
	public void question1() {
		Student[] studentArr = new Student[3];
		System.out.println("Khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên" + (i + 1) + ":");
			Student st = new Student();
			studentArr[i] = st;
		}
		System.out.println("thông tin các sinh viên vừa nhập:");
		for (int i = 0; i < studentArr.length; i++) {
			System.out.println(studentArr[i]);
		}
		Student.collect = "Đại học công nghệ";
		for (int i = 0; i < studentArr.length; i++) {
			System.out.println(studentArr[i]);
		}
	}

	public void question2() {
		Student[] studentArr = new Student[3];
		System.out.println("Khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên" + (i + 1) + ":");
			Student st = new Student();
			studentArr[i] = st;
		}
		System.out.println("Các sinh viên nộp quỹ, mỗi bạn 100K: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 300) + "k");
		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 50) + "k");
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 20) + "k");
		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
		System.out.println("Cả nhóm mỗi người lại đóng quỹ mỗi người 50k: ");

		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 150));
	}
}
