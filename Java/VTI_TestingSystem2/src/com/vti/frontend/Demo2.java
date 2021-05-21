package com.vti.frontend;

import java.time.LocalDate;
import java.util.Locale;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class Demo2 {
	public static void main(String[] args) {
//		    Question 1:
//			Kiểm tra account thứ 2
//			Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//			"Nhân viên này chưa có phòng ban"
//			Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
		if (acc2.departmentID == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là" + acc2.deparmentID.name);
		}
//			Question 2:
//			Kiểm tra account thứ 2
//			Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//			Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
//			này là Java Fresher, C# Fresher"
//			Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
//			quan trọng, tham gia nhiều group"
//			Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
//			người hóng chuyện, tham gia tất cả các group"
		if (acc2.groups == null) {
			System.out.println("Nhan vien nay chua co phong ban");
		} else {
			int countGroup = acc2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên\r\n" + "này là Java Fresher, C# Fresher");
			}
			if (countGroup == 3) {
				System.out.println("Nhân viên này là người\r\n" + "quan trọng, tham gia nhiều group");
			}
			if (countGroup >= 4) {
				System.out.println("Nhân viên này là\r\n" + "người hóng chuyện, tham gia tất cả các group");
			}
		}
//			Question 3:
//			Sử dụng toán tử ternary để làm Question 1
		System.out.println(acc2.departmentID == null ? "Nhan vien nay chua co phong ban"
				: "Phong cua nhan vien nay la " + acc2.departmentID.name);
//			Question 4:
//			Sử dụng toán tử ternary để làm yêu cầu sau:
//			Kiểm tra Position của account thứ 1
//			Nếu Position = Dev thì in ra text "Đây là Developer"
//			Nếu không phải thì in ra text "Người này không phải là Developer"
		System.out.println(acc1.positionID == pos1 ? "Đây là Developer" :  "Người này không phải là Developer:");
		
//		    Question 5:
//			Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//			Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//			Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//			Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//			Còn lại in ra "Nhóm có nhiều thành viên"
		if (group2.accounts == null) {
			System.out.println("Nhan vien nay chua co phong ban");
		} else {
			int countAccInGroup = group2.accounts.length;
			switch (countAccInGroup) {
			case 1:
				System.out.println("Nhóm có một thành viên");
				break;
			case 2:
				System.out.println("Nhóm có hai thành viên");
				break;
			case 3:
				System.out.println("Nhóm có ba thành viên");
				break;
			default:
				System.out.println("Nhóm có nhiều thành viên");
				break;
			}

		}
//		    Question 6:
//			Sử dụng switch case để làm lại Question 2
		int acc2InGroup = acc2.groups.length;
		switch (acc2InGroup) {
		case 0:
			System.out.println("Nhân viên này chưa có Group");
			break;
		case 1 :
			System.out.println("Group của nhân viên này là Java Fresher ,C# Fresher ");
			break;
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher ,C# Fresher ");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện tham gia tất cả các group");
			break;
		}		
//			Question 7:
//			Sử dụng switch case để làm lại Question 4
		int acc1InPos = acc1.positionID.id;
		switch (acc1InPos) {
		case 1:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}

//		FOREACH
//		Question 8:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//		họ
		Account[] accs = {acc1 , acc2};
		for (Account x : accs ) {
			System.out.println(x.email);
			System.out.println(x.fullName);
			System.out.println(x.departmentID.name);
		}
//		Question 9:
//		In ra thông tin các phòng ban bao gồm: id và name
//		FOR
		Position[] poss = {pos1 ,pos2 ,pos3 ,pos4};
		for (Position position : poss) {
			System.out.println(position.id);
			System.out.println(position.name);
		}
//		Question 10:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//		họ theo định dạng như sau:
//		Thông tin account thứ 1 là:
//		Email: NguyenVanA@gmail.com
//		Full name: Nguyễn Văn A
//		Phòng ban: Sale
//		Thông tin account thứ 2 là:
//		Email: NguyenVanB@gmail.com
//		Full name: Nguyễn Văn B
//		Phòng ban: Marketting
		Account[] array1 ={ acc1 ,acc2};
		for (int i = 0; i < array1.length; i++) {
			System.out.println(array1[i].email);
			System.out.println(array1[i].fullName);
			System.out.println(array1[i].departmentID.name);
		}
//		Question 11:
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//		Thông tin department thứ 1 là:
//		Id: 1
//		Name: Sale
//		Thông tin department thứ 2 là:
//		Id: 2
//		Name: Marketing
		Department[] arraydep = {dep1 ,dep2 ,dep3};
		for (int i = 0; i < arraydep.length; i++) {
			System.out.println(arraydep[i].id);
			System.out.println(arraydep[i].name);
		}
//		Question 12:
//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		Department[] arrDep = {dep1 , dep2};
		for (int i = 0; i < arrDep.length; i++) {
			System.out.println(arraydep[i].id);
			System.out.println(arraydep[i].name);
		}
//		Question 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2
		Account[] arrAcc = {acc1, acc3 ,acc5};
		for (int i = 0; i < arrAcc.length; i++) {
			System.out.println(arrAcc[i].id);
			System.out.println(arrAcc[i].email);
			System.out.println(arrAcc[i].fullName);
		}
//		Question 14:
//		In ra thông tin tất cả các account có id < 4
		for (int j = 0; j < arrAcc.length; j++) {
			if(arrAcc[j].id < 4) {
				System.out.println(arrAcc[j].id);
				System.out.println(arrAcc[j].email);
				System.out.println(arrAcc[j].fullName);
			}
		}
//		Question 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20
		for (int i = 0; i <= 20; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
//		WHILE
//		Question 16:
//		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
//		lệnh break, continue
		int x;
		while (x% 2 == 0 && x <= 20) {
			System.out.println(x);
		}
//		DO-WHILE
//		Question 17:
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
//		lệnh break, continue
		int i = 0;
		Account[] arrAcc = {acc1, acc3 ,acc5};
		do {
			System.out.println(arrAcc[i].id);
			System.out.println(arrAcc[i].email);
			System.out.println(arrAcc[i].fullName);
		} while (arrAcc[i].id < 4);
//		Exercise 2 (Optional): System out printf
//		Question 1:
//		Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
//		nguyên đó
		int x =5 ;
		System.out.println(x);
//		Question 2:
//		Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//		ra số nguyên đó thành định dạng như sau: 100,000,000
		int a = 100000000;
		System.out.printf(Locale.US,"%,d %n", 10000);
//		Question 3:
//		Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//		thực đó chỉ bao gồm 4 số đằng sau
		float  a =  5.567098f;
	    String test = String.format("%.04f", a);
	    System.out.println(test);
//		Question 4:
//		Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//		dạng như sau:
//		Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//		Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		String ho_Va_Ten = "Nguyễn Văn A";
		System.out.println("Tên tôi là"+ ho_Va_Ten +" và tôi đang độc thân");
//		Question 5:
//		Lấy thời gian bây giờ và in ra theo định dạng sau:
//		24/04/2020 11h:16p:20s
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
		System.out.println(ldt);
//		Question 6:
//		In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//		table (giống trong Database)

		
		
		
	}
	
}

