"use strict";
exports.__esModule = true;
var Account_1 = require("./Account");
var account1 = new Account_1.Account(1, "a1@vti", "dark", "nguyendark");
var account2 = new Account_1.Account(2, "a2@vti", "brush", "brushnguyen");
var account3 = new Account_1.Account(3, "a3@vti", "lmao", "lmaonguyen");
var account4 = new Account_1.Account(4, "a4@vti", "xloc", "xlocduong");
// console.log("In theo cach 1: ");
// printInforStaff(account1);
// console.log("In theo cach 2: ");
// printAccount(account2);
// console.log("In theo cach 3: ");
// print_Account_ArrowFunction(account3);
// console.log("In theo cach 4: ");
// print_Account_ArrowFunction1(account4);
// Demo Map
var account_Array;
account_Array = [account1, account2, account3, account4];
console.log("Thông tin Account sử dụng map");
account_Array.map(function (account, key) {
    console.log("STT: ", key);
    Account_1.printInforStaff(account);
});
