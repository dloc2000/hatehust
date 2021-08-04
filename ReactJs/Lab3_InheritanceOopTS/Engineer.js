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
exports.Engineer = void 0;
var Staff_1 = require("./Staff");
var Engineer = /** @class */ (function (_super) {
    __extends(Engineer, _super);
    function Engineer(name, age, gender, address, specializad) {
        var _this = _super.call(this, name, age, gender, address) || this;
        _this.specializad = specializad;
        return _this;
    }
    /**
     * Getter specializad
     * @return {string }
     */
    Engineer.prototype.getSpecializad = function () {
        return this.specializad;
    };
    /**
     * Setter specializad
     * @param {string } value
     */
    Engineer.prototype.setSpecializad = function (value) {
        this.specializad = value;
    };
    Engineer.prototype.printIn4Engineer = function () {
        console.log("Thông tin của kỹ sư là: ");
        _super.prototype.printIn4Staff.call(this);
        console.log("Specializad: " + this.setSpecializad);
    };
    ;
    return Engineer;
}(Staff_1.Staff));
exports.Engineer = Engineer;
