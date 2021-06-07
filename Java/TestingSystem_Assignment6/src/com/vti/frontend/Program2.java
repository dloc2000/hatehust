package com.vti.frontend;

public class Program2 {
	public static void main(String[] args) {
		try {
			float result = divide(7, 1);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("cannot divide 0");
		} finally {
			System.out.println("divide completed");
		}
		try {
			int[] number = {1, 2, 3};
			System.out.println(number[10]);
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
		;

	}

	private static float divide(int a, int b) {
		return a / b;
	}
}
