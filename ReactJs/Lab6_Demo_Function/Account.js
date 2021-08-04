"use strict";
exports.__esModule = true;
exports.print_Account_ArrowFunction1 = exports.print_Account_ArrowFunction = exports.printAccount = exports.printInforStaff = exports.Account = void 0;
var Account = /** @class */ (function () {
    function Account(id, email, username, fullname) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
    }
    /**
     * Getter id
     * @return {number}
     */
    Account.prototype.getId = function () {
        return this.id;
    };
    /**
     * Getter email
     * @return {string}
     */
    Account.prototype.getEmail = function () {
        return this.email;
    };
    /**
     * Getter username
     * @return {string}
     */
    Account.prototype.getUsername = function () {
        return this.username;
    };
    /**
     * Getter fullname
     * @return {string}
     */
    Account.prototype.getFullname = function () {
        return this.fullname;
    };
    /**
     * Setter id
     * @param {number} value
     */
    Account.prototype.setId = function (value) {
        this.id = value;
    };
    /**
     * Setter email
     * @param {string} value
     */
    Account.prototype.setEmail = function (value) {
        this.email = value;
    };
    /**
     * Setter username
     * @param {string} value
     */
    Account.prototype.setUsername = function (value) {
        this.username = value;
    };
    /**
     * Setter fullname
     * @param {string} value
     */
    Account.prototype.setFullname = function (value) {
        this.fullname = value;
    };
    return Account;
}());
exports.Account = Account;
// C1
function printInforStaff(account) {
    console.log("id:  " + account.getId() + "Name: " + account.getEmail()
        + "Username: " + account.getUsername() + "fullName: " + account.getFullname());
}
exports.printInforStaff = printInforStaff;
;
// C2
var printAccount = function prin_other(account) {
    console.log("id:  " + account.getId() + "Name: " + account.getEmail()
        + "Username: " + account.getUsername() + "fullName: " + account.getFullname());
};
exports.printAccount = printAccount;
// C3 Arrow Function
var print_Account_ArrowFunction = function (account) {
    console.log("id:  " + account.getId() + "Name: " + account.getEmail()
        + "Username: " + account.getUsername() + "fullName: " + account.getFullname());
};
exports.print_Account_ArrowFunction = print_Account_ArrowFunction;
//C4 viết thu gọn Arrow Function
var print_Account_ArrowFunction1 = function (account) {
    return console.log("id:  " + account.getId() + "Name: " + account.getEmail()
        + "Username: " + account.getUsername() + "fullName: " + account.getFullname());
};
exports.print_Account_ArrowFunction1 = print_Account_ArrowFunction1;
