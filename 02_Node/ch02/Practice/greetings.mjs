// import * as say from './ems.mjs'; 전체 모듈 가져오기
// say.hi('홍길동');
// say.goodbye('홍길동');

import { hi as hello, goodbye as bye } from './ems.mjs';
hello('홍길동');
bye('홍길동');
