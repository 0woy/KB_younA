import getBase, { add } from './module.mjs';

console.log(add(4));
console.log(getBase());
console.log();

// 전개 연산자
let obj1 = { name: '박문수', age: 29 };
let obj2 = { ...obj1, email: 'mspark@gmail.com' };
console.log(obj2);
console.log();

let arr1 = [100, 200, 300];
let arr2 = ['hello', ...arr1, 'world'];
console.log(arr1);
console.log(arr2);
console.log();

// Promise
const p = new Promise((resolve, reject) => {
  setTimeout(() => {
    let num = Math.random(); //0~1사이의 난수 발생
    if (num >= 0.8) {
      reject(`생성된 숫자가 0.8 이상임 - ${num}`);
    }
    resolve(num);
  }, 2000);
});
p.then((result) => {
  console.log('처리 결과 : ', result);
}).catch((error) => {
  console.log('오류 : ', error);
});
console.log('## Promise 객체 생성!');

// Promise 체인
let promise = new Promise((resolve, reject) => {
  resolve('first!');
});

promise
  .then((msg) => {
    console.log(msg);
    return 'second';
  })
  .then((msg) => {
    console.log(msg);
    return 'third';
  })
  .then((msg) => {
    console.log(msg);
  })
  .catch((err) => {
    console.log('오류 발생 ==>' + err);
  });
