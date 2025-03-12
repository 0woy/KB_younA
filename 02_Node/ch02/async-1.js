function A() {
  console.log('A');
}

function B(callback) {
  setTimeout(() => {
    console.log('B');
    callback();
  }, 2000);
}

function C() {
  console.log('C');
}

A();
B(C);
