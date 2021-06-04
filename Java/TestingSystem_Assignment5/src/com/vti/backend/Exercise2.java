package com.vti.backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Student;

public class Exercise2 {
	private ArrayList<Student> listStudent;
	Random rd = new Random();
	private Scanner sc;
	
	public Exercise2() {
		listStudent = new ArrayList<Student>();
		sc = new Scanner(System.in);
	}
	public void question1() {
		while(true) {
			System.out.println("=======================================================================");
					
					System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng ===================");
					
					System.out.println("=== 1. Tạo danh sách sinh viên.  ===");
					
					System.out.println("=== 2. Hiển thị ds sv trong lớp. ===");
					
					System.out.println("=== 3. Điểm danh lớp             ===");
					
					System.out.println("=== 4. Gọi nhóm 1 đi học bài     ===");
					
					System.out.println("=== 5. Gọi nhóm 2 đi dọn vệ sinh ===");
					
					System.out.println("=== 6. Exit.                     ===");
					
					System.out.println("=======================================================================");
				int menuChoose = sc.nextInt();
				switch (menuChoose) {
				case 1:
					initStudent();
					System.out.println("Đã tạo được 10 học sinh");
					break;
				case 2:
					for (Student student1 : listStudent) {
						System.out.println(student1.toString());
					}
					break;
				case 3:
					 System.out.println("Điểm danh lớp: ");
					 for (Student student : listStudent) {
						student.diemDanh();
					}
					break;
				case 4:
					for (Student student : listStudent) {
						if(student.getGroup() == 1) {
							student.hocBai();
						}
					}
					break;
				case 5:
					for (Student student : listStudent) {
						if(student.getGroup() == 2) {
							student.donWc();
						}
					}
					break;
				case 6:
	
					return;
	

				default:
					System.out.println("Nhập sai mời nhập lại");
				}
		}
	}
	private void initStudent() {
		for(int i =0 ; i<10 ; i++) {
			Student student = new Student("Student" + (i+1), rd.nextInt(3)+1);
			listStudent.add(student);
		}
		
		
	}
}
