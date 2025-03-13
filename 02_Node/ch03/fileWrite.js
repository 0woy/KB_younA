const fs = require('fs');

const root = './ch03/';
const likes = fs.readFileSync(`${root}likes.txt`);

// writeFileSync(): 동기로 파일 읽기
fs.writeFileSync('./ch03/test-01.txt', likes);
let read = fs.readFileSync('./ch03/test-01.txt', 'utf-8');
console.log(read);
console.log();

let data = 'hello world!';
fs.writeFileSync('./ch03/hello.txt', data);
read = fs.readFileSync('./ch03/hello.txt', 'utf-8');
console.log(read);

//writeFile(): 비동기로 파일 읽기
fs.readFile(`${root}likes.txt`, 'utf-8', (err, files) => {
  if (err) {
  }
  if (fs.existsSync(`${root}test-02.txt`)) {
    console.log('this file aleady exists');
  } else {
    fs.writeFile(`${root}test-02.txt`, files, (err) => {
      if (err) {
      }
      console.log('저장');
    });
  }
});

if (fs.existsSync('./03')) {
  console.log('folder aleady exists');
} else {
  fs.mkdir('./03', (err) => {
    if (err) {
      return console.log(err);
    } else {
      console.log('folder is created');
    }
  });
}

if (fs.existsSync('./test2/test3')) {
  console.log('이미 있어유');
} else {
  fs.mkdir('./test2/test3', { recursive: true }, (err) => {
    if (err) {
      console.log('에러');
    } else {
      console.log('만듦');
    }
  });
}
