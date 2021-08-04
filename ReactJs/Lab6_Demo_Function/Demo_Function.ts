import { Account, printAccount, printInforStaff, print_Account_ArrowFunction, print_Account_ArrowFunction1 } from "./Account";


let account1 = new Account(1 , "a1@vti" ,"dark" ,"nguyendark");
let account2 = new Account(2 , "a2@vti" ,"brush" ,"brushnguyen");
let account3 = new Account(3 , "a3@vti" ,"lmao" ,"lmaonguyen");
let account4 = new Account(4 , "a4@vti" ,"xloc" ,"xlocduong");
// console.log("In theo cach 1: ");
// printInforStaff(account1);

// console.log("In theo cach 2: ");
// printAccount(account2);

// console.log("In theo cach 3: ");
// print_Account_ArrowFunction(account3);

// console.log("In theo cach 4: ");
// print_Account_ArrowFunction1(account4);

// Demo Map
let account_Array: Account[];
account_Array = [account1 , account2 ,account3 , account4];
console.log("Thông tin Account sử dụng map");
account_Array.map(function (account: Account, key: number){
    console.log("STT: " , key + 1);
    printInforStaff(account);
})

