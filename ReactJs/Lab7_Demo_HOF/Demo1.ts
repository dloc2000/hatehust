
import { Employee } from "./Employee";
import { Engineer } from "./Engineer";
import { Staff } from "./Staff";
import { Workers } from "./Workers";


// Tạo ra các đối tượng
let worker1 = new Workers("Worker1", 20, "Male", "HN", 10);
let worker2 = new Workers("Worker2", 22, "FeMale", "NĐ", 7);
let worker3 = new Workers("Worker3", 24, "Male", "HN", 8);

let Engineer1 = new Engineer("Engineer1", 20, "Male", "HN", "DEV");
let Engineer2 = new Engineer("Engineer2", 22, "FeMale", "NĐ", "TEST");
let Engineer3 = new Engineer("Engineer3", 24, "Male", "HN", "DEV");

let Employee1 = new Employee("Employee1", 20, "Male", "HN", "Task1"); 
let Employee2 = new Employee("Employee2", 22, "FeMale", "NĐ", "Task2");
let Employee3 = new Employee("Employee3", 24, "Male", "HN", "Task3");

let staff_Array: Staff[] = [
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
console.log("Demo cách gọi bthg cách 1")

function printInforWorkers(staff: Staff[]){
    staff.forEach(element => {
        if(element instanceof Workers){
            element.printInforWorker();
        }
    });
}

function printInforEmployee(staff: Staff[]){
    staff.forEach(element => {
        if(element instanceof Employee){
            element.printInforEmployee();
        }
    });
}

// chỉ gọi workers
printInforWorkers(staff_Array);

// Cách 2 dùng HOF , tham số đầu vào là 1 hàm , đầu ra là 1 hàm 

function printInforStaff(staff: Staff[] , function_print) {
    return function_print(staff_Array);
};

console.log("Thông tin staff in theo HOF");
printInforStaff(staff_Array , printInforEmployee);

// Cách 3 viết hàm truyền giá trị là 1 object
console.log("----------In thông tin theo Cách 3-----------");

function printStaffArray_3(staff: Staff[] , params){
    staff.forEach(element =>{
        if(element instanceof params){
            console.log("Thông tin : " , element);
        }
    })
}

printStaffArray_3(staff_Array , Employee);