import { Workers } from "./Workers";
import { Engineer } from "./Engineer";
import { Employee } from "./Employee";


// let worker1 = new Workers("NguyenVanA" , 20 , "Nam" , "Ha Noi", 10 );
// let worker2 = new Workers("NguyenVanB" , 18 , "Nam" , "Ha Noi", 6 );
// let worker3 = new Workers("NguyenThiC" , 19 , "Nữ" , "Hcm", 8 );

// let workArray: Workers[];
// workArray = [worker1,worker2,worker3];

// workArray.forEach(element => {
//     element.printIn4Woker();
// });

let engineer1 = new Engineer("Engineer A" , 30 , "Nam" , "Ha Noi", "DEV" );
let engineer2 = new Engineer("Engineer B" , 28 , "Nam" , "Nghe An", "PM" );
let engineer3 = new Engineer("Engineer C" , 1000 , "Nữ" , "Hcm", "TEST" );

let engineerSet = new Set();
engineerSet.add(engineer1);
engineerSet.add(engineer2);
engineerSet.add(engineer3);

console.log("Xoa thang so 3" + engineerSet.delete(engineer3));
console.log("dem so phan tu" + engineerSet.size);
engineerSet.forEach(element => {
    console.log(element);
});


let employee1 = new Employee("Engineer A" , 30 , "Nam" , "Ha Noi", "task1" );
let employee2 = new Employee("Engineer B" , 28 , "Nam" , "Nghe An", "task2" );
let employee3 = new Employee("Engineer C" , 1000 , "Nữ" , "Hcm", "task3" );

let employeeArray: Employee[];
employeeArray = [employee1,employee2,employee3];

employeeArray.forEach(element => {
    element.printIn4Employee();
});