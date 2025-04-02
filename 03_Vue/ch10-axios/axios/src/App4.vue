<template>
  <div id="app">
    <h2>콘솔 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';
const url = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = async () => {
  let data = { todo: 'ppt 만들기', desc: '그냥 대충만들기' };
  // const response = await axios.post(url, data);
  // console.log(response.data);
};
requestAPI();
</script>
