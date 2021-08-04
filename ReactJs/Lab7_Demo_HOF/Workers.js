"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.Workers = void 0;
var Staff_1 = require("./Staff");
var Workers = /** @class */ (function (_super) {
    __extends(Workers, _super);
    function Workers(name, age, gender, address, rank) {
        var _this = _super.call(this, name, age, gender, address) || this;
        _this.rank = rank;
        return _this;
    }
    /**
     * Getter rank
     * @return {number}
     */
    Workers.prototype.getRank = function () {
        return this.rank;
    };
    /**
     * Setter rank
     * @param {number} value
     */
    Workers.prototype.setRank = function (value) {
        this.rank = value;
    };
    Workers.prototype.printInforWorker = function () {
        console.log("Thông tin worker");
        _super.prototype.printInforStaff.call(this);
        console.log("Rank: ", this.rank);
    };
    return Workers;
}(Staff_1.Staff));
exports.Workers = Workers;
