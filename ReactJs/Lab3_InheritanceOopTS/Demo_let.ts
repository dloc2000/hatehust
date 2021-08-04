import { Workers } from "./Workers";


var name: string = "Worker1";
var age = 18;
var gender = "Male";
var address;
address = "HN";
var rank: number = 7;


let worker1 = new Workers(name, age, gender, address, rank);

console.log("Thông tin worker1");
worker1.printIn4Woker();
 // let worker1; // báo lỗi
var worker2;
 console.log('In thông tin thông qua khai báo thêm 1 hàm: ');
function printWorker_array(): void {
 var workerArray: Workers[]; // Khai báo 1 mảng
 workerArray = [worker1, worker2]; // Do worker1, worker2 khai báo var nên có phạm vi toàn cục
 workerArray.forEach(element => { // Sử dụng Foreach để in thông tin worker trong mảng
 console.log(element);
});
worker2 = new Workers("Worker2_Name2_Change", 22, "Male_Change", "HN_Change", 9);// khai báo lại
//worker2 trong hàm này. thay đổi giá trị
let worker4 = new Workers("Worker3", 22, "Male", "HN", 9);// Worker4 khai báo bên trong hàm, nên
// chỉ có phạm vi bên trong hàm này. ra ngoài sẽ không gọi được, giống khi báo với var
}


printWorker_array(); // ở đây vẫn lấy ra được các giá trị worker1 và worker đã khai báo bên ngoài
// In lại thông tin worker để kiểm tra sau khi thay đổi trong hàm printWorker_array();
console.log('Thông tin Worker sau khi thay đổi trong hàm printWorker_array');
console.log(worker2);