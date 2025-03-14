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
console.log();

// this
let obj = { result: 0 };
obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  inner();
};
obj.add(3, 4);
console.log(obj);
console.log(result);
console.log();

// Q10 객체 리터럴
let age = 20;
let email = 'gdhong@test.com';
let obj2 = { age, email };
console.log(obj2);
console.log();

let p1 = {
  name: '아이패드',
  price: 200000,
  quantity: 2,
  order: function () {
    // 기존 방법
    if (!this.amount) {
      this.amount = this.quantity * this.price;
    }
    console.log('주문금액 : ' + this.amount);
  },
  discount(rate) {
    // ES6의 메서드 선언
    if (rate > 0 && rate < 0.8) {
      this.amount = (1 - rate) * this.price * this.quantity;
    }
    console.log(100 * rate + '% 할인된 금액으로 구매합니다.');
  },
};
p1.discount(0.2);
p1.order();

// Q12 리터럴 템플릿
const d1 = new Date();
let name = '홍길동';
let r1 = `${name} 님에게 ${d1.toDateString()}에 연락했다.`;
console.log(r1);
let product = '갤럭시S7';
let price = 199000;
let str = `${product}의 가격은
    ${price}원 입니다.`;
console.log(str);
