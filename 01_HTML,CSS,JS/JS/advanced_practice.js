// Q1
let date = new Date();
let hour = date.getHours();
let mission;

if (hour < 5) mission = '잠을 자렴....';
else if (hour >= 5 && hour < 7) mission = '준비';
else if (hour >= 7 && hour < 9) mission = '출근';
else if (hour >= 9 && hour < 12) mission = '빈둥빈둥';
else if (hour >= 12 && hour < 14) mission = '식사';
else mission = '여러 가지 업무를 수행합니다.';
console.log(mission);

// Q2
let arr = [10, 20, 30, 40, 50];
let total = 0;
for (let i in arr) {
  total += arr[i];
}
console.log(total);

//Q3 callback
function callFunctions(time, callback) {
  for (let i = 0; i < time; i++) {
    callback();
  }
}

let call = function () {
  alert('함수 호출');
};
//callFunctions(10, call);

//Q4 noname callback
callFunctions(11, function () {
  console.log('익명 함수 호출');
});
