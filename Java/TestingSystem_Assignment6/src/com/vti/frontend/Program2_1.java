package com.vti.frontend;

public class Program2_1 {
	public static void main(String[] args) {
		
		try {
			int[] numbers = {1,2,3};
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Mảng nhập vào quá giá trị");
		}
	}
}
