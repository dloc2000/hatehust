package com.vti.frontend;

import com.vti.entity.Department;

public class Demo2 {
	public static void main(String[] args) {
		question4();
	}

	public static void question4() {
		
		 try {
			 Department dep1 = new Department("Dep1");
				Department dep2 = new Department("Dep2");
				Department dep3 = new Department("Dep3");
				Department dep4 = new Department("Dep4");
				Department dep5 = new Department("Dep5");
				Department[] depsArr = {dep1 ,dep2 ,dep3 ,dep4 ,dep5};
				System.out.println(depsArr[6]);
		} catch (Exception e) {
			System.out.println("Khong hop le");
		}

	}
}
