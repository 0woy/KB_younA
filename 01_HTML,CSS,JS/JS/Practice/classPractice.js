let userInput = prompt('3의 배수 찾기');
let arr = [];
idx = 0;
let total = 0;
for (let i = 1; i <= userInput; i++) {
  if (i % 3 == 0) {
    arr[idx] = i;
    total += arr[idx++];
  }
}

document.getElementById('find').textContent = arr.join(', ');
document.getElementById('count').textContent =
  userInput + '까지 3의 배수의 갯수 : ' + arr.length;
document.getElementById('total').textContent =
  userInput + '까지 3의 배수의 합 : ' + total;

let gugudan = '';
for (let j = 1; j <= 9; j++) {
  for (let i = 2; i <= 9; i++) {
    gugudan += `${i}*${j}=${i * j}\t`;
  }
  gugudan += '<br>';
}
document.getElementById('gugudan').innerHTML = gugudan;
