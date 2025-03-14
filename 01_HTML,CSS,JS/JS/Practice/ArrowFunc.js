// 중첩 함수에서의 this
let obj = { result: 0 };
obj.add = function (x, y) {
  const inner = () => {
    this.result = x + y;
  };
  inner();
};

obj.add(3, 4);
console.log(obj); // { result: 7, add: [Function (anonymous)] }

const person1 = {
  age: 10,
  grow: function () {
    this.age++;
    console.log(this.age);
  },
};
person1.grow();

const person2 = {
  age: 10,
  grow: () => {
    this.age++;
    console.log(this.age);
  },
};

person2.grow();
