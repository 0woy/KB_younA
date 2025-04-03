<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add"
        >할 일 추가</router-link
      >
      <button class="btn btn-primary ms-1" @click="fetchTodoList">
        새로 고침
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>
<script setup>
import TodoItem from '@/components/TodoItem.vue';
import { inject } from 'vue';

const todoList = inject('todoList');
const { fetchTodoList } = inject('actions');
</script>
