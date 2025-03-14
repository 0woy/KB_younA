let obj = { result: 0 };
obj.add = function (x, y) {
  this.result = x + y;
};
// obj.add(3, 4);

let add2 = obj.add;
add2(3, 4);
console.log(obj);

let sum = function (x, y) {
  this.result = x + y;
};

let res = {};
sum.apply(res, [3, 4]);
console.log(res);

sum.call(res, 3, 5);
console.log(res);

sum = sum.bind(res);
sum(3, 8);
console.log(res);
