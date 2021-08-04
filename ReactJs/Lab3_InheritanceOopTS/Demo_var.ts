import { Workers } from "./Workers";


var name: string = "Worker1";
var age = 18;
var gender = "Male";
var address;
address = "HN";
var rank: number = 7;

var worker1 = new Workers(name, age, gender, address, rank);

console.log('Thông tin worker 1: ')
worker1.printIn4Woker();

console.log('Thông tin worker1_ Sau khi khai báo biến var lại 1 lần nữa');
var worker1 = new Workers("Worker1_Name1", 20, "FeMale", "HN", 10);
worker1.printIn4Woker();
