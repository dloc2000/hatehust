package com.vti.frontend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

import com.vti.entity.Exam;

public class Demo3 {

//	Exercise 3 (Optional): Date Format
//	Question 1:
//	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//	dạng vietnamese
	Exam[] exams= {ex1 ,ex2};
	Locale locale = new Locale("vn", "VN");
	DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,
	locale);
	String date = dateformat.format(ex1.createDate);
	System.out.println(ex1.code + ": " + date);
//	Question 2:
//	In ra thông tin: Exam đã tạo ngày nào theo định dạng
//	Năm – tháng – ngày – giờ – phút – giây
//	Question 3:
//	Chỉ in ra năm của create date property trong Question 2
	String pattern = "yyyy-MM-dd-HH-mm-ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	Exam[] exams = { ex1, ex2 };
	for (Exam ex : exams) {
	date = simpleDateFormat.format(ex.createDate);
	System.out.println(ex.code + ": " + date);
	}
	
//	Question 4:
//	Chỉ in ra tháng và năm của create date property trong Question 2
	String pattern = "yyyy-MM";
	simpleDateFormat = new SimpleDateFormat(pattern);
	for (Exam ex : exams) {
	date = simpleDateFormat.format(ex.createDate);
	System.out.println(ex.code + ": " + date);
	}
//	Question 5:
//	Chỉ in ra "MM-DD" của create date trong Question 2
	String pattern = "MM-dd";
	simpleDateFormat = new SimpleDateFormat(pattern);
	for (Exam ex : exams) {
	date = simpleDateFormat.format(ex.createDate);
	System.out.println(ex.code + ": " + date);
	}
//	Exercise 4 (Optional): Random Number
//	Question 1:
//	In ngẫu nhiên ra 1 số nguyên
	Random random = new Random();
	int x = random.nextInt();
	System.out.println("Số ngẫu nhiên: " + x);
//	Question 2:
//	In ngẫu nhiên ra 1 số thực
	float f = random.nextFloat();
	System.out.println("Số ngẫu nhiên: " + f);
	
//	Question 3:
//	Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
//	ra tên của 1 bạn
	String[] nameArr = { "Loc", "Nhung", "Dao", "Kien" };
	int i = random.nextInt(nameArr.length);
	System.out.println("tên ngẫu nhiên là: " + nameArr[i]);
//	Question 4:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
	Random random = new Random();
	int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
	int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
	long randomInt = minDay + random.nextInt(maxDay - minDay);
	LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
	System.out.println(randomDay);
//	Question 5:
//	Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
	int now = (int) LocalDate.now().toEpochDay();
	int randomDate = now - random.nextInt(365);
	LocalDate reusultDate = LocalDate.ofEpochDay(randomDate);
	System.out.println("Ngày ngẫu nhiên là: " + reusultDate);
//	Question 6:
//	Lấy ngẫu nhiên 1 ngày trong quá khứ
	int maxDay1 = (int) LocalDate.now().toEpochDay();
	long randomDay1 = random.nextInt(maxDay1);
	LocalDate resultDate1 = LocalDate.ofEpochDay(randomDay1);
	System.out.println("1 Ngày ngẫu nhiên trong quá khứ: " + resultDate1);
	
//	Question 7:
//	Lấy ngẫu nhiên 1 số có 3 chữ số
	int n = random.nextInt(999 - 100 + 1) + 100; 
	System.out.println(n);
//	Exercise 5: Input from console
//	Question 1:
//	Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	Scanner sc = new Scanner(System.in);
	System.out.println("Mời bạn nhập vào 3 số nguyên");
	System.out.println("Nhập vào số 1: ");
	int a = sc.nextInt();
	System.out.println("Nhập vào số 2: ");
	int b = sc.nextInt();
	System.out.println("Nhập vào số 3: ");
	int c = sc.nextInt();
	System.out.println("Bạn vừa nhập vào các số: " + a + " " + b + "
	" + c);"
//	Question 2:
//	Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình		
	System.out.println("Mời bạn nhập vào 2 số thực");
	System.out.println("Nhập vào số 1: ");
	float f1 = sc.nextFloat();
	System.out.println("Nhập vào số 2: ");
	float f2 = sc.nextFloat();
	System.out.println("Bạn vừa nhập vào các số: " + f1 + " " + f2);
}
