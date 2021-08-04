import { Account } from "./Account";
import { Department } from "./Department";
import { Position } from "./Position";

let date = new Date();

let dep1 = new Department(1 , "Bao ve");

let pos1 = new Position(2 ,"Dev");

let acc1 = new Account(1 ,"email1@vti.com" ,"dloc2000", "DXL" ,dep1 ,pos1 , date);

console.log(acc1);