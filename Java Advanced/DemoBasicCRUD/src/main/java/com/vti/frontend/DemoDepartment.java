package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DemoDepartment {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int choose = menu();
		
		
		switch (choose) {
		case 1:
			showAllDepartment();
			break;
		case 2:
			System.out.println("Nhập vào ID của phòng ban");
			short idDep = sc.nextShort();
			
			showDepartmentId(idDep);
			break;
		case 3:
			System.out.println("Nhập vào tên phòng ban");
			String nameDep = sc.next();
			showDepartmentName(nameDep);
			break;
		case 4:
			System.out.println("Tạo mới phòng ban");
			System.out.println("Nhập tên phòng cần tạo:");
			String nameDepCreate = sc.next();
			
			Department dep = new Department();
			dep.setName(nameDepCreate);
			createDep(dep);
			showAllDepartment();
			
			break;
		default:
			break;
		}
	}

	private static void createDep(Department dep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		depRepository.createDepartment(dep);
		
	}

	private static void showDepartmentName(String nameDep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department depByName = depRepository.getDepartmentByName(nameDep);
		if(depByName == null) {
			System.out.println("Không có phòng ban này");
			
		}
		else {
			System.out.println(depByName.toString());
		}
	}

	private static void showDepartmentId(Short idDep) {
		DepartmentRepository depRepository = new DepartmentRepository();
		Department depById = depRepository.getDepartmentByID(idDep);
		if(depById == null) {
			System.out.println("Không có phòng ban này");
			
		}
		else {
			System.out.println(depById.toString());
		}
	}

	private static void showAllDepartment() {
		System.out.println("Danh sách phòng ban trên hệ thống");
		DepartmentRepository depRepository = new DepartmentRepository();
		List<Department> listDep = depRepository.getAllDepartments();
		for (Department department : listDep) {
			System.out.println(department.toString());
		}
	}

	private static int menu() {
		while(true) {
			System.out.println("CHương trình quản lý phòng ban..");
			System.out.println("Mời bạn nhập vào chức năng muốn sử dụng");
			System.out.println("1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.println("2. Tìm phòng ban theo ID");
			System.out.println("3. Tìm phòng ban theo Name");
			System.out.println("4. Tạo mới 1 phòng");
			Scanner sc = new Scanner(System.in);
			if(sc.hasNextInt()) {
				int i = sc.nextInt();
				if( i == 1 || i == 2 || i == 3 || i == 4) {
					return i;
				}else {
					System.out.println("Nhap lai");
				}
			}else {
				System.out.println("Nhap lai");
			}
		}
		
	}
}
