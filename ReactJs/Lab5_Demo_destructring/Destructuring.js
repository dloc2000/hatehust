"use strict";
var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var __spreadArray = (this && this.__spreadArray) || function (to, from) {
    for (var i = 0, il = from.length, j = to.length; i < il; i++, j++)
        to[j] = from[i];
    return to;
};
exports.__esModule = true;
var account = {
    name: "daonq",
    age: 20,
    gender: "Nam",
    address: "HN"
};
//
// let name_let = account.name;
// let age_let = account.age;
// let gender_let = account.gender;
// let address_let = account.address;
//
var name_let = account.name, age_let = account.age, gender_let = account.gender, address_let = account.address;
console.log(name_let);
console.log(age_let);
console.log(gender_let);
console.log(address_let);
var worker = __assign(__assign({}, account), { rank: "golden" });
console.log(worker);
// destructuring Array
var name_Arr = ["name1", "name2", "name3"];
var Student1 = name_Arr[0], Student2 = name_Arr[1], Student3 = name_Arr[2];
console.log("Student1: ", Student1);
console.log("Student1: ", Student2);
console.log("Student1: ", Student3);
//
var name_Array_new = __spreadArray(__spreadArray([], name_Arr), ["Name4", "Name5", "Name6"]);
for (var index = 0; index < name_Array_new.length; index++) {
    console.log("Sinh vien", index + 1, name_Array_new[index]);
}
