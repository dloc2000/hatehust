"use strict";
exports.__esModule = true;
exports.printIn4Department = exports.Department = void 0;
var Department = /** @class */ (function () {
    function Department(id, name) {
        this.id = id;
        this.name = name;
    }
    // get,set of name
    Department.prototype.getName = function () {
        return this.name;
    };
    Department.prototype.setName = function (name) {
        this.name = name;
    };
    // get , set of Id
    Department.prototype.getId = function () {
        return this.id;
    };
    Department.prototype.setId = function (id) {
        this.id = id;
    };
    return Department;
}());
exports.Department = Department;
// Function ko phu thuoc vao class
function printIn4Department(department) {
    console.log("ID: ", department.getId(), "Name: ", department.getName());
}
exports.printIn4Department = printIn4Department;
var dep1 = new Department(1, "trang oc cho");
printIn4Department(dep1);
