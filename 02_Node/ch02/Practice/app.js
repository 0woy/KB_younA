const { user1, user2 } = require('./user-1');
const hello = require('./hello'); // Common.js 에서 모듈 가져오기
hello(user1);
hello(user2);
