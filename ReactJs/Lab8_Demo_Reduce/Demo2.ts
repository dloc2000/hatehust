import { Staff } from "./Staff";


let staff1 = new Staff("staff1", 20, "Male", "HN");
let staff2 = new Staff("staff2", 22, "FeMale", "NĐ");
let staff3 = new Staff("staff3", 24, "Male", "HN");

// Tạo mảng để lưu các đối tượng
let staff_Array: Staff[];
staff_Array = [staff1, staff2, staff3];

let totalAge = staff_Array.reduce((total_age , current_age) => total_age + current_age.getAge() , 0);

console.log("Tuổi trung bình của các staff là: " ,totalAge/staff_Array.length);