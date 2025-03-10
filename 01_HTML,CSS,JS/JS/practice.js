// Q1 출력
// alert('Hello JavaScript...!');
console.log('"Hello World..!"');
console.log("'Hello World..!'");

//Q2 변수
const pi = 3.14159265;
let r = 10;
console.log('원의 넓이: ' + pi * r * 2);

//Q3 ,4 date
let data = new Date();
let hour = data.getHours();
let month = data.getMonth();

if (hour < 12) {
  console.log('오전입니다.');
} else {
  console.log('오후입니다.');
}

switch (month + 1) {
  case 3:
  case 4:
  case 5:
    console.log('봄입니다.');
    break;
  case 6:
  case 7:
  case 8:
    console.log('여름입니다.');
    break;
  case 9:
  case 10:
  case 11:
    console.log('가을입니다.');
    break;
  case 12:
  case 1:
  case 2:
    console.log('겨울입니다.');
    break;
}

// Q5~ Q7 for~while문
let arr = [10, 20, 30, 40, 50];
console.log(arr.length);
for (let i in arr) {
  console.log(arr[i]);
}

let i = 0;
while (i < arr.length) {
  console.log(arr[i++]);
}

let total = 0;
for (let i = 1; i <= 100; i++) {
  total += i;
}
console.log(total);

//Q8 함수
function pow(v) {
  return v * v;
}
console.log(pow(3));

//Q9 객체
let object = {
  제품명: '7D 건조 망고',
  유형: '당절임',
  성분: '망고, 설탕, 메타중아황산나트륨, 치자황색소',
  원산지: '필리핀',
};

for (let i in object) {
  console.log(i + ':' + object[i]);
}

let person = {
  name: '유인성',
  eat: function (food) {
    console.log(this.name + '이 ' + food + '을/를 먹습니다.');
  },
};

person.eat('밥');
