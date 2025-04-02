<template>
  <div id="app">
    <h2>콘솔 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';
const url = '/api/todos2';
const todoUrlPrefix = '/api/todos/';

const errorApi = async () => {
  try {
    let response = await axios.get(url, { timeout: 900 });
    console.log('응답객체: ', response);
  } catch (error) {
    console.log('## 다음 오류가 발생했습니다.');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

const requestAPI = async () => {
  let todoList;
  let response = await axios.get(url);
  todoList = response.data;

  console.log('## TodoList', todoList);
  for (let i = 0; i < todoList.length; i++) {
    response = await axios.get(todoUrlPrefix + todoList[i].id);
    console.log(`# ${i + 1}번째 Todo: `, response.data);
  }
};
// requestAPI();
errorApi();
</script>
