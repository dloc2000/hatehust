package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.VietnamesePhone;

public class Exercise6 {
	Scanner sc;

	public Exercise6() {
		sc = new Scanner(System.in);
	}

	public void question1() {
		loadMenuAbstract();
	}

	private void loadMenuAbstract() {
		VietnamesePhone vnPhone = new VietnamesePhone();
		while (true) {
			System.out.println("======================================================================");				
					System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");	
					System.out.println("=== 1. InsertContact.===");
					
					System.out.println("=== 2. RemoveContact.===");
					
					System.out.println("=== 3. UpdateContact.===");
					 
					System.out.println("=== 4. SearchContact ===");
					
					System.out.println("=== 5. ShowContact   ===");
					 
					System.out.println("=== 6. Thoát khỏi chương trình. ===");
					
					System.out.println("======================================================================");
					
					int menuChoose = sc.nextInt();
				switch (menuChoose) {
				case 1:
					System.out.println("Nhập vào tên Contact: ");
					String name = sc.next();
					System.out.println("Nhập vào tên số Phone: ");
					String phone = sc.next();
					vnPhone.insertContact(name, phone);
					break;
				case 2:
					System.out.println("Nhập vào tên Contact cần remove:");
					String remove =sc.next();
					vnPhone.removeContact(remove);
					break;
				case 3:
					System.out.println("Nhập tên cần Update: ");
					String name1 = sc.next();
					System.out.println("Nhập số Phone mới: ");
					String newPhone = sc.next();
					vnPhone.updateContact(name1, newPhone);
					break;
				case 4:
					System.out.println("Nhập vào tên Contact cần tìm kiếm: ");
					String searchName = sc.next();
					vnPhone.searchContact(searchName);
					break;
case 5:
	vnPhone.printContact();
	break;
case 6:
	return;


				default:
					System.out.println("Nhập sai mời nhập lại.");
					break;
				}	
			
		}
	}
}
