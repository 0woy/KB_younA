const fs = require('fs');
const { dirname } = require('path');

// readdirSync: 동기로 디렉토리 내 파일 이름 출력
let files = fs.readdirSync('./ch02');
console.log(files);
console.log();

// readdir: 비동기로 디렉토리 내 파일 이름 출력
fs.readdir('./ch02', (err, files) => {
  if (err) {
    console.log(err);
  } else {
    console.log(files);
  }
  console.log();
});

// readFileSync(): 동기로 파일 읽기
const likes = fs.readFileSync('./ch03/likes.txt', 'utf-8');
console.log(likes);
console.log();

// readFile(): 비동기로 파일 읽기
fs.readFile('./ch03/likes.txt', 'utf-8', (err, data) => {
  if (err) {
    console.log(err);
  } else {
    console.log(data);
  }
});
