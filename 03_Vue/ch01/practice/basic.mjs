import { h } from 'vue';

// Q1
let msg = 'GLOBAL';
function outer() {
  let msg = 'OUTER';
  console.log(msg);
  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }
  console.log(msg);
}
outer();

console.log();
// Q2 const 객체 -> 메모리 주소 변경x
const person = { name: '0woy', age: 20 };
person.age = 25;
console.log(person);

console.log();
//Q3 기본 매개변수
function addContact({
  name,
  mobile,
  home = '없음',
  address = '없음',
  email = '없음',
}) {
  console.log(name, mobile, home, address, email);
}

addContact({ name: 'kim', mobile: '010-654-6546' });
addContact({
  name: 'kim',
  mobile: '010-654-6546',
  home: '02-654-6543',
  address: '서울시',
});

console.log();
//Q4 가변 매개변수
function foodReport(name, age, ...foodFavorite) {
  console.log(name, age);
  console.log(foodFavorite);
}
foodReport('이몽룡', 20, '짜장면', '냉면', '불고기');
foodReport('홍길동', 16, '초밥');

console.log();

// Q5 배열 구조 분해
let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);

let p1 = { name: '홍길동', age: 20, gender: 'M' };
let { name: n, age: a, gender } = p1;
console.log(n, a, gender);
console.log();

//Q6 객체 구조 분해
function addContact1({ name, phone, email = '이메일없음', age = 0 }) {
  console.log(name, phone, email, age);
}
addContact1({ name: '이몽룡', phone: '010-3434-8989' });

function addContact2(contact) {
  if (!contact.email) contact.email = '이메일없음';
  if (!contact.age) contact.age = 0;
  let { name, phone, email, age } = contact;
  console.log(name, phone, email, age);
}
addContact2({ name: '이몽룡', phone: '010-3434-8989' });

function addContact3(name, phone, email = '이메일없음', age = 0) {
  console.log(name, phone, email, age);
}
addContact3('이몽룡', '010-3434-8989');
console.log();

//Q8 화살표 함수
const test1 = function (a, b) {
  return a + b;
};
const test2 = (a, b) => a + b;

const test3 = (a, b) => {
  return a + b;
};
console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
