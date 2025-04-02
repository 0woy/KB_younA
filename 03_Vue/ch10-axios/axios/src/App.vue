<template>
  <div>
    <h2>콘솔 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';
const url = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  let todoList = [];
  axios
    .get(url)
    .then((response) => {
      todoList = response.data;
      console.log('# TodoList : ', todoList);
      return todoList[0].id;
    })
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      console.log('## 첫 번째 todo: ', response.data);
      return todoList[1].id;
    })
    .then((id) => {
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두 번째 todo: ', response.data);
      });
    });
};
requestAPI();
</script>
