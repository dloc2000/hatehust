let numArray = [10, 20 ,30];

let total = 0 ;
numArray.forEach((element) => {
    total = total + element ;
});

console.log("Cách 1: Tổng các số trong mảng numArray là: " , total);


// Sử dụng Reduce Function để tính tổng
function callBack(accumulator, currentValue, currentIndex){
    console.log("--- Lần lặp " , currentIndex + 1 ,"-----")
    console.log("Accumulator hiện tại: ", accumulator);
    console.log("currentValue hiện tại" , currentValue);
    console.log("currentIndex hiện tại" , currentIndex);
    accumulator += currentValue;
    return accumulator;
}

// let total_reduce = numArray.reduce(callBack , total);
// console.log(total_reduce);

// C3: Tối ưu lại cách viết Reduce function
let total_reduce_toiUu = numArray.reduce((accumulator , currentValue) => accumulator + currentValue , 0)
console.log("Sau khi tối ưu : " , total_reduce_toiUu );

// C4: sử dụng intitalValue khác 0
let total_reduce_toiUu_intital = numArray.reduce((accumulator , currentValue) => accumulator + currentValue , 100)
console.log("Sau khi tối ưu : " , total_reduce_toiUu_intital );

