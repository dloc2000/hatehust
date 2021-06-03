package com.vti.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Engineer;
import com.vti.entity.Staff;
import com.vti.entity.Staff.Gender;
import com.vti.entity.Worker;

public class Exercise5 {
	private Scanner sc;
	private ArrayList<Staff> staffList;

	public Exercise5() {
		staffList = new ArrayList<Staff>();
		sc = new Scanner(System.in);
	}

	public void question2() {
		while (true) {
			System.out.println("=======================================================================");
			System.out.println("============= Lựa chọn chức năng bạn muốn sử dụng =====================");
			System.out.println("===           1.Thêm mới cán bộ                                     ===");
			System.out.println("===           2.Tìm kiếm theo họ tên                                ===");
			System.out.println("===           3.Hiển thị thông tin về danh sách các cán bộ          ===");
			System.out.println("===           4.Nhập vào tên của cán bộ và xóa cán bộ đó            ===");
			System.out.println("===           5.Thoát khỏi chương trình                             ===");
			System.out.println("=======================================================================");
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				addStaff();
				System.out.println("Mời bạn thêm nhân viên : ");
				break;
			case 2:
				findByName();
				break;
			case 3:
				printListStaff();
				break;
			case 4:
				deleteByName();
				break;
			case 5:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}

		}
	}

	

	private void addStaff() {
		System.out.println("==================================");
		System.out.println("======Lựa chọn chức năng bạn muốn sử dụng :");
		System.out.println("======1. Thêm engineer");
		System.out.println("======2. Thêm Worker");
		System.out.println("======3. Thêm Employee");
		System.out.println("==================================");
		int choose1 = sc.nextInt();

		switch (choose1) {
		case 1:
			System.out.println("Nhập vào tên của kĩ sư : ");
			String nameEngineer = sc.next();
			System.out.println("Nhập vào tuổi Engineer: ");
			int ageEngineer = sc.nextInt();
			System.out.println("Nhập vào giới tính Engineer 1.Male,2.Female, 3.Unknown");
			int flagEngineer = sc.nextInt();
			Gender genderName1 = null;
			switch (flagEngineer) {
			case 1:
                genderName1  = Gender.MALE;
				break;
			case 2:
				genderName1 = Gender.FEMALE;
				break;
			case 3:
				genderName1 = Gender.UNKNOWN;
				break;
			}
			System.out.println("Nhập vào địa chỉ Engineer: ");
			String addEngineer = sc.next();
			System.out.println("Nhập vào chuyên ngành Engineer: ");
			String specializedEngineer = sc.next();
			Staff engineer = new Engineer(nameEngineer,ageEngineer,genderName1,addEngineer,specializedEngineer);
			staffList.add(engineer);
			break;
		case 2 :
			System.out.println("Nhập vào tên Worker: ");
			String nameWorker = sc.next();
			System.out.println("Nhập vào tuổi Worker: ");
			int ageWorker = sc.nextInt();
			System.out.println("Nhập vào giới tính Worker 1.Male,2.Female, 3.Unknown");
			
			int flagGender = sc.nextInt();
			Gender genderName = null;
			switch (flagGender) {
			case 1:
			genderName = Gender.MALE;
			break;
			case 2:
			genderName = Gender.FEMALE;
			break;
			case 3:
			genderName = Gender.UNKNOWN;
			break;
			}
			System.out.println("Nhập vào địa chỉ Worker: ");
			String addWorker = sc.next();
			System.out.println("Nhập vào bậc Worker: ");
			int rankWorker = sc.nextInt();
			Staff worker = new Worker(nameWorker, ageWorker,genderName, addWorker, rankWorker);			
			staffList.add(worker);
			break;

		case 3 :
				System.out.println("Nhập vào tên Employee: ");
				String nameEmployee = sc.next();
				System.out.println("Nhập vào tuổi Employee: ");
				int ageEmployee = sc.nextInt();
				System.out.println("Nhập vào giới tính Employee 1.Male,2.Female, 3.Unknown");				
				int flagEmployee = sc.nextInt();
				Gender genderEmployee = null;
				switch (flagEmployee) {
				case 1:
				genderEmployee = Gender.MALE;
				break;
				case 2:
				genderEmployee = Gender.FEMALE;
				break;
				case 3:
				genderEmployee = Gender.UNKNOWN;
				break;
				}
				System.out.println("Nhập vào địa chỉ Employee: ");
				String addEmployee = sc.next();
				System.out.println("Nhập vào nhiệm vụ Employee: ");
				String taskEmployee = sc.next();
				Staff Employee = new com.vti.entity.Employee(nameEmployee,ageEmployee, genderEmployee, addEmployee,taskEmployee);
				staffList.add(Employee);

			break;
		}

	}

	private void findByName() {
		System.out.println("Nhập vào tên muốn tìm kiếm: ");
		String findName = sc.next();
		for (Staff staff : staffList) {
			if(staff.getName().equals(findName)) {
				System.out.println(staff);
			}
		}
	
	}

	private void printListStaff() {
for (Staff staff : staffList) {
	System.out.println(staff);
}
	}

	private void deleteByName() {
		System.out.println("Nhập tên cần xóa thông tin: ");
		String delName = sc.next();
		Iterator<Staff> iterator = staffList.iterator();
		while(iterator.hasNext()) {
			Staff staff = iterator.next();
			if(staff.getName().equals(delName)) {
				iterator.remove();
			}
		}
	}
}
