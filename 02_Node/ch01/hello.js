// function hello(name) {
//   console.log(name + '님 안녕하세요?');
// }

// hello('0woy');
const c = require('ansi-colors');
function boring(name) {
  console.log(c.green(name) + '님 안녕하세요');
}
boring('0woy');
