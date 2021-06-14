package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.DAO.DepartmentDao;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Exercise2 {
	private DepartmentDao depDAO;

	public Exercise2() throws FileNotFoundException, IOException {
		depDAO = new DepartmentDao();
	}

	public void question1() throws ClassNotFoundException, SQLException {
		List<Department> listDep1 = depDAO.getListDepartment();
		String leftAlignFormat = "| %-6d | %-21s |%n";
		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : listDep1) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("(\"+--------+-----------------------+%n");

	}

	public void question2() throws ClassNotFoundException, SQLException {
		System.out.println("Tìm thông tin phòng có ID = 5");
		Department depQues2 = depDAO.getDepByID(5);
		if (depQues2 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Department Name |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, depQues2.getId(), depQues2.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}

	public void question3() throws ClassNotFoundException, SQLException {
		System.out.println("Tìm kiếm phòng theo ID: ");
		System.out.println("Nhập vào ID cần tìm kiếm");
		int idFind = ScannerUltis.inputIntPositive();
		Department depQues3 = depDAO.getDepByID(idFind);
		if (depQues3 != null) {
			String leftAlignFormat = "| %-6d | %-21s |%n";
			System.out.format("+--------+-----------------------+%n");
			System.out.format("| ID | Department Name |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, depQues3.getId(), depQues3.getName());
			System.out.format("+--------+-----------------------+%n");
		} else {
			System.out.println("Không tồn tại phòng này trên HT");
		}
	}

	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra tên phòng đã có trên hệ thống? ");
		System.out.println("Nhập vào tên cần kiểm tra: ");
		String nameCheck = ScannerUltis.inputString();
		Boolean checkResult = depDAO.isDepartmentNameExists(nameCheck);
		if (checkResult) {
			System.out.println("Tên đã có trên hệ thống.");
			question1();
		} else {
			System.out.println("tên chưa có trên hệ thống");
		}
	}

	public void question5() throws ClassNotFoundException, SQLException {
		String newNameDep = getNewName();
		if (depDAO.createDep(newNameDep)) {
			System.out.println("Tạo thành công.");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	private String getNewName() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhập vào tên phòng cần tạo: ");
			String newName = ScannerUltis.inputString();
			if (depDAO.isDepartmentNameExists(newName)) {
				System.out.println("Đã có phòng trên hệ thống");
			} else {
				return newName;
			}
		}
	}

	public void question6() throws ClassNotFoundException, SQLException {
		question1();
		int updateID = getIdUpdate();
		System.out.println("Nhập vào tên cần Update: ");
		String newName = ScannerUltis.inputString();
		if (depDAO.updateDepartmentName(updateID, newName)) {
			System.out.println("Update tên phòng thành công: ");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

	private int getIdUpdate() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Nhập ID phòng cần Update: ");
			int id = ScannerUltis.inputIntPositive();
			Department dep = depDAO.getDepByID(id);
			if (dep == null) {
				System.out.println("Không có ID này trên HT");
			} else {
				return id;
			}
		}
	}

	public void question7() throws ClassNotFoundException, SQLException {
		question1();
		int updateID = getIdUpdate();
		if (depDAO.delDepByID(updateID)) {
			System.out.println("Xóa phòng thành công");
			question1();
		} else {
			System.out.println("Đã có lỗi xảy ra");
		}
	}

}
