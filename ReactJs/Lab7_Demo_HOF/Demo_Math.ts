// Định nghĩa 1 số hàm toán học

function sum(a: number, b: number) {
    return a + b ;
}
function div(a: number, b: number) {
    return a - b ;
}
function multiply(a: number, b: number) {
    return a * b ;
}
console.log(" Demo cách gọi hàm thường");
// Phép cộng
let sum_a_b = sum(20, 10);
console.log("Kết quả của phép cộng 2 số là: " ,sum_a_b);

function caculator(a: number , b: number , operator){
    let result = operator(a ,b);
    console.log("Kết quả của phép tính " ,operator ," là: " , result);
}

caculator(20 , 30 ,sum);
caculator(10 ,3000 , div);
caculator(100231, 213129 , multiply);