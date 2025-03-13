const { dir } = require('console');
const fs = require('fs');
const fpromise = fs.promises;
const path = require('path');

// 스트림을 이용해 파일 읽고 콘솔에 출력
const root = './ch03/writeMe.txt';
const output = './ch03/likes.txt';
const read = fs.createReadStream(`${root}`);
const write = fs.createWriteStream(`${output}`);

read.pipe(write);

read.on('data', (data) => {});
read.on('end', () => {
  console.log('끝났음');
});
read.on('err', (err) => {
  console.log(err);
});

// 현재 디렉토리 항목 Promise로 읽어서 출력
let readPromise = new Promise((resolve, reject) => {
  let dirs = fs.readdirSync(`./${path.basename(__dirname)}`);
  resolve(dirs);
  reject('디렉토리 항목 못 읽었어요');
});

readPromise
  .then((result) => {
    console.log(result);
  })
  .catch((err) => {
    console.log(err);
  });

// async / await 변환
async function readDir(url) {
  try {
    let dirs = await fpromise.readdir(url);
    console.log('DirectoryContent: ', dirs);
    return dirs;
  } catch (err) {
    console.log(err);
  }
}

readDir(`${path.basename(__dirname)}`);
