"use strict";
exports.__esModule = true;
var Engineer_1 = require("./Engineer");
var Employee_1 = require("./Employee");
// let worker1 = new Workers("NguyenVanA" , 20 , "Nam" , "Ha Noi", 10 );
// let worker2 = new Workers("NguyenVanB" , 18 , "Nam" , "Ha Noi", 6 );
// let worker3 = new Workers("NguyenThiC" , 19 , "Nữ" , "Hcm", 8 );
// let workArray: Workers[];
// workArray = [worker1,worker2,worker3];
// workArray.forEach(element => {
//     element.printIn4Woker();
// });
var engineer1 = new Engineer_1.Engineer("Engineer A", 30, "Nam", "Ha Noi", "DEV");
var engineer2 = new Engineer_1.Engineer("Engineer B", 28, "Nam", "Nghe An", "PM");
var engineer3 = new Engineer_1.Engineer("Engineer C", 1000, "Nữ", "Hcm", "TEST");
var engineerSet = new Set();
engineerSet.add(engineer1);
engineerSet.add(engineer2);
engineerSet.add(engineer3);
console.log("Xoa thang so 3" + engineerSet["delete"](engineer3));
console.log("dem so phan tu" + engineerSet.size);
engineerSet.forEach(function (element) {
    console.log(element);
});
var employee1 = new Employee_1.Employee("Engineer A", 30, "Nam", "Ha Noi", "task1");
var employee2 = new Employee_1.Employee("Engineer B", 28, "Nam", "Nghe An", "task2");
var employee3 = new Employee_1.Employee("Engineer C", 1000, "Nữ", "Hcm", "task3");
var employeeArray;
employeeArray = [employee1, employee2, employee3];
employeeArray.forEach(function (element) {
    element.printIn4Employee();
});
