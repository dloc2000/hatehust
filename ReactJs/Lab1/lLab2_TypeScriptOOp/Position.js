"use strict";
exports.__esModule = true;
exports.printIn4Position = exports.Position = void 0;
var Position = /** @class */ (function () {
    function Position(id, name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Getterid
     *
     */
    Position.prototype.getid = function () {
        return this.id;
    };
    /**
     * Gettername
     *
     */
    Position.prototype.getname = function () {
        return this.name;
    };
    /**
     * Setterid
     *
     */
    Position.prototype.setid = function (value) {
        this.id = value;
    };
    /**
     * Settername
     *
     */
    Position.prototype.setname = function (value) {
        this.name = value;
    };
    return Position;
}());
exports.Position = Position;
function printIn4Position(position) {
    console.log("Id: " + position.getid + "Name: " + position.getname);
}
exports.printIn4Position = printIn4Position;
var dep1 = new Position(1, "trang oc cho");
printIn4Position(dep1);
