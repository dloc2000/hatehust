package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Demo1 {
	public static void main(String[] args) {
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Marketing";
		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "Sale";
		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Bao ve";
		/* -------------------- */
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;
		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.PM;
		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.Scrum_master;
		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.Test;

		Account acc5 = new Account();
		acc5.id = 1;
		acc5.email = "NguyenVanC@gmail.com";

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "NguyenVanB@gmail.com";

		/* -------------------- */
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Development";
		group1.creatorID = acc5;

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "Managment";
		group2.creatorID = acc3;
		/* -------------------- */
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "NguyenVanA@gmail.com";
		acc1.fullName = "Nguyen van A";
		acc1.userName = "user1";
		acc1.departmentID = dep1;
		acc1.positionID = pos1;
		acc1.createDate = LocalDate.of(2021, 05, 14);
		Group[] groupsAcc1 = { group1, group2 };
		acc1.groups = groupsAcc1;

		Account acc2 = new Account();
		acc2.id = 1;
		acc2.email = "NguyenVanB@gmail.com";
		acc2.fullName = "Nguyen van B";
		acc2.userName = "user2";
		acc2.departmentID = dep2;
		acc2.positionID = pos2;
		acc2.createDate = LocalDate.now();
		Group[] groupsAcc2 = { group1 };
		acc2.groups = groupsAcc2;
		/* -------------------- */	
//
//		for (int i = 0; i <= 20; i++) {
//			if(i%2 == 0) {
//				System.out.println(i);
//			}
//		}
//		int i = 0;
//		Account[] arrAcc = {acc1, acc3 ,acc5};
//		do {
//			System.out.println(arrAcc[i].id);
//			System.out.println(arrAcc[i].email);
//			System.out.println(arrAcc[i].fullName);
//		} while (arrAcc[i].id < 4);
//		System.out.println("In thong tin cua account tren he thong");
//		System.out.println("thong tin account 1");
//		System.out.println("ID:" + acc1.id);
//		System.out.println("Email: " + acc1.email);
//		System.out.println("fullName: " + acc1.fullName);
//		System.out.println("Deparment: " + acc1.departmentID.name);
//		System.out.println("Groups: " + acc1.groups[0].name + " " + acc1.groups[1].name);
//		System.out.println("CreateDate: " + acc1.createDate);	

	}
}
