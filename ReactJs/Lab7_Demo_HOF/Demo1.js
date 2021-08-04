"use strict";
exports.__esModule = true;
var Employee_1 = require("./Employee");
var Engineer_1 = require("./Engineer");
var Workers_1 = require("./Workers");
// Tạo ra các đối tượng
var worker1 = new Workers_1.Workers("Worker1", 20, "Male", "HN", 10);
var worker2 = new Workers_1.Workers("Worker2", 22, "FeMale", "NĐ", 7);
var worker3 = new Workers_1.Workers("Worker3", 24, "Male", "HN", 8);
var Engineer1 = new Engineer_1.Engineer("Engineer1", 20, "Male", "HN", "DEV");
var Engineer2 = new Engineer_1.Engineer("Engineer2", 22, "FeMale", "NĐ", "TEST");
var Engineer3 = new Engineer_1.Engineer("Engineer3", 24, "Male", "HN", "DEV");
var Employee1 = new Employee_1.Employee("Employee1", 20, "Male", "HN", "Task1");
var Employee2 = new Employee_1.Employee("Employee2", 22, "FeMale", "NĐ", "Task2");
var Employee3 = new Employee_1.Employee("Employee3", 24, "Male", "HN", "Task3");
var staff_Array = [
    worker1,
    worker2,
    worker3,
    Engineer1,
    Engineer2,
    Engineer3,
    Employee1,
    Employee2,
    Employee3,
];
// Cách 1 goi bình thường
console.log("Demo cách gọi bthg cách 1");
function printInforWorkers(staff) {
    staff.forEach(function (element) {
        if (element instanceof Workers_1.Workers) {
            element.printInforWorker();
        }
    });
}
function printInforEmployee(staff) {
    staff.forEach(function (element) {
        if (element instanceof Employee_1.Employee) {
            element.printInforEmployee();
        }
    });
}
// chỉ gọi workers
printInforWorkers(staff_Array);
// Cách 2 dùng HOF , tham số đầu vào là 1 hàm , đầu ra là 1 hàm 
function printInforStaff(staff, function_print) {
    return function_print(staff_Array);
}
;
console.log("Thông tin staff in theo HOF");
printInforStaff(staff_Array, printInforEmployee);
// Cách 3 viết hàm truyền giá trị là 1 object
console.log("----------In thông tin theo Cách 3-----------");
function printStaffArray_3(staff, params) {
    staff.forEach(function (element) {
        if (element instanceof params) {
            console.log("Thông tin : ", element);
        }
    });
}
printStaffArray_3(staff_Array, Employee_1.Employee);
