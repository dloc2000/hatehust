package com.vti.frontend;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import com.vti.utils.ScannerUltis;

public class DemoAccount {
	public static void main(String[] args) {
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Danh sách Account trên hệ thống");
			System.out.format(leftAlignFormat, "2. Danh sách Account Theo ID");
			System.out.format(leftAlignFormat, "3. Tạo mới Account");
			System.out.format(leftAlignFormat, "4. Xóa Account");
			System.out.format(leftAlignFormat, "5. Update Account");
			System.out.format(leftAlignFormat, "6.	Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");
			
			switch (ScannerUltis.inputIntPositive()) {
			case 1:
				getAllAccount();
				break;

			default:
				break;
			}
		}

	}

	private static void getAllAccount() {
		System.out.println("Danh sách Account trên hệ thống");
		AccountRepository accRepository = new AccountRepository();
		List<Account> listAcc = accRepository.getAllAccount();
		
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		
		for (Account account : listAcc) {
			
		  System.out.format(leftAlignFormat, account.getId(), account.getEmail() , account.getUserName() , account.getFullName() , account.getDepartment().getName() , account.getPosition().getName() , account.getCreateDate() );   
		
		  System.out.format(
					"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------+%n");

		}
		
	}
}
