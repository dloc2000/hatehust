package com.vti.frontend;

import java.util.List;
import java.util.Scanner;

import com.vti.Repository.AccountRepository;
import com.vti.entity.Account;
import com.vti.utils.ScannerUltis;

public class DemoHQLAccount {
	public static void main(String[] args) {
		AccountRepository accountRepository = new AccountRepository();
		
//		System.out.println("Nhập vào ID của account cần tìm kiếm : ");
//		int id = ScannerUltis.inputIntPositive();
//		
//		String fullname = accountRepository.getFullName((short) id);
//		System.out.println("Fullname của Account đó là :" + fullname);
//		
//		List<Account> list1 = accountRepository.getByCurrentMonth();
		
		System.out.println("Demo Phân trang với Hibernate: ");
		 List<Account> list2 = accountRepository.getAccountByPaging();
		 for (Account account : list2) {
		 System.out.println("ID: " + account.getId() + " Email:" + account.getEmail() + " Username: "
				 + account.getUserName()+ " FullName: " + account.getFullName() + " Department: "
						 + account.getDepartment().getName() + " Possition: " + account.getPosition().getName());	
	
		 }

	}
}
