const path = require('path');

// join(): 입력한 경로 조각 합치기
const fullpath = path.join('some', 'work', 'ex.txt');
console.log(fullpath);
console.log();
// dirname(): 경로만 추출 path.dirname()
console.log(`파일 절대 경로: ${__filename}`);
const dir = path.dirname(__filename);
console.log(`경로만 추출: ${dir}`);

console.log();

// basename(): 파일 이름, 확장자 제외 파일 이름
const fn = path.basename(__filename);
const fn2 = path.basename(__filename, '.js');
console.log(`파일 이름: ${fn}`);
console.log(`확장자 x 파일 이름 : ${fn2}`);

console.log();
// extname(): 확장자 알아내기
const ext = path.extname(__filename);
const find = path.basename(__filename, ext);
console.log(`확장자: ${ext}`);
console.log(`파일 이름: ${find}`);

console.log();

// parse(): 경로 -> 객체 변환
const parsePth = path.parse(__filename);
console.log(parsePth);
