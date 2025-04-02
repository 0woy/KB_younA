<template>
  <div id="app">
    <h2>사용자 목록</h2>
    <button type="button" id="user" @click="showScreen = true">조회</button>
    <div v-if="showScreen">
      <h2>사용자 정보</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>이름</th>
            <th>나이</th>
            <th>전화번호</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in userList" :key="user.id">
            <td>{{ user.id }}</td>
            <td>{{ user.name }}</td>
            <td>{{ user.age }}</td>
            <td>{{ user.phone }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <h2>새 사용자 추가</h2>
    <form>
      <input type="text" v-model="name" value="" placeholder="이름" />
      <input type="text" v-model="age" value="" placeholder="나이" />
      <input type="text" v-model="phone" placeholder="전화번호" />
      <button type="submit" @click="addUsers">추가</button>
    </form>
  </div>
</template>
<script setup>
import axios from 'axios';
import { ref, reactive } from 'vue';
const url = '/api/users';
const usersUrlPrefix = '/api/users/';

let showScreen = ref(false);
let userList = reactive([]);
const name = ref('');
const age = ref('');
const phone = ref('');

const addUsers = async () => {
  if (!name.value || !age.value || !phone.value) {
    return;
  }
  let data = { name: name.value, age: age.value, phone: phone.value };
  let response = await axios.post(usersUrlPrefix, data);
  con;
};

const getUsers = async () => {
  let response = await axios.get(url);
  userList = response.data;
};
getUsers();
</script>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th,
td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

tr {
  border-bottom: 1px solid #ddd;
}

tr:last-child {
  border-bottom: none;
}
input {
  margin-right: 10px;
}
</style>
