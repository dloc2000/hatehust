package com.vti.ultis;

import java.util.Scanner;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.next().trim());
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	public static int inputIntPositive() {
		while (true) {
			try {
				int intPositive = Integer.parseInt(sc.next());
				if (intPositive >= 0) {
					return intPositive;
				} else {
					System.err.println("Nhập lại:");
				}
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static Float inputFloat(String mes) {
		while (true) {
			try {
				return Float.parseFloat(sc.next());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static Double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.next());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String string = sc.nextLine().trim();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.err.println("Nhập lại:");
			}
		}
	}
}
