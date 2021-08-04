"use strict";
exports.__esModule = true;
exports.printIn4Account = exports.Account = void 0;
var Account = /** @class */ (function () {
    function Account(id, email, username, fullname, department, position, createDate) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.department = department;
        this.position = position;
        this.createDate = createDate;
    }
    /**
     * Getterid
     *
     */
    Account.prototype.getid = function () {
        return this.id;
    };
    /**
     * Getteremail
     *
     */
    Account.prototype.getemail = function () {
        return this.email;
    };
    /**
     * Getterusername
     *
     */
    Account.prototype.getusername = function () {
        return this.username;
    };
    /**
     * Getterfullname
     
     */
    Account.prototype.getfullname = function () {
        return this.fullname;
    };
    /**
     * Getterdepartment
     * }
     */
    Account.prototype.getdepartment = function () {
        return this.department;
    };
    /**
     * Getterposition
     *
     */
    Account.prototype.getposition = function () {
        return this.position;
    };
    /**
     * GettercreateDate
     *
     */
    Account.prototype.getcreateDate = function () {
        return this.createDate;
    };
    /**
     * Setterid
     *
     */
    Account.prototype.setid = function (value) {
        this.id = value;
    };
    /**
     * Setteremail
     *
     */
    Account.prototype.setemail = function (value) {
        this.email = value;
    };
    /**
     * Setterusername
     *
     */
    Account.prototype.setusername = function (value) {
        this.username = value;
    };
    /**
     * Setterfullname
     *
     */
    Account.prototype.setfullname = function (value) {
        this.fullname = value;
    };
    /**
     * Setterdepartment
     *
     */
    Account.prototype.setdepartment = function (value) {
        this.department = value;
    };
    /**
     * Setterposition
     *
     */
    Account.prototype.setposition = function (value) {
        this.position = value;
    };
    /**
     * SettercreateDate
     *
     */
    Account.prototype.setcreateDate = function (value) {
        this.createDate = value;
    };
    return Account;
}());
exports.Account = Account;
function printIn4Account(account) {
    console.log("Id: " + account.getid()
        + "email: " + account.getemail()
        + "username: " + account.getusername()
        + "fullname: " + account.getfullname()
        + "department: " + account.getdepartment().getName
        + "position: " + account.getposition().getname
        + "createDate: " + account.getcreateDate());
}
exports.printIn4Account = printIn4Account;
