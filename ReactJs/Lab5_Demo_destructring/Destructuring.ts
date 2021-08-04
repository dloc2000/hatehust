import { SSL_OP_CIPHER_SERVER_PREFERENCE } from "constants";

let account = {
    name: "daonq",
    age: 20,
    gender: "Nam",
    address: "HN",
}
//
// let name_let = account.name;
// let age_let = account.age;
// let gender_let = account.gender;
// let address_let = account.address;

//
let {name: name_let, age: age_let, gender: gender_let, address: address_let} = account;
console.log(name_let);
console.log(age_let);
console.log(gender_let);
console.log(address_let);

let worker = {
    ...account,
    rank: "golden",
}
console.log(worker);

// destructuring Array
let name_Arr: string[] = ["name1" ,"name2" ,"name3"];
let[Student1, Student2, Student3] = name_Arr;
console.log("Student1: " , Student1);
console.log("Student1: " , Student2);
console.log("Student1: " , Student3);
//
let name_Array_new: string[] = [...name_Arr , "Name4" ,"Name5" , "Name6"];

for (let index = 0; index < name_Array_new.length; index++) {
    console.log( "Sinh vien", index + 1 ,name_Array_new[index]); 
}
