"use strict";
exports.__esModule = true;
var Staff_1 = require("./Staff");
var staff1 = new Staff_1.Staff("staff1", 20, "Male", "HN");
var staff2 = new Staff_1.Staff("staff2", 22, "FeMale", "NĐ");
var staff3 = new Staff_1.Staff("staff3", 24, "Male", "HN");
// Tạo mảng để lưu các đối tượng
var staff_Array;
staff_Array = [staff1, staff2, staff3];
var totalAge = staff_Array.reduce(function (total_age, current_age) { return total_age + current_age.getAge(); }, 0);
console.log("Tuổi trung bình của các staff là: ", totalAge / staff_Array.length);
