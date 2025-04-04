<template>
  <div id="app">
    <h2>TodoList 테스트</h2>
    <hr />
    할일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="item in todoList">
        <span style="cursor: pointer" @click="toggleDone(item.id)">
          {{ item.todo }} {{ item.done ? '(완료)' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(item.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할 일 수: {{ doneCount }}</div>
  </div>
</template>
<script setup>
import { useTodoListStore } from '@/stores/todoList.js';
import { ref, computed } from 'vue';
const todo = ref('');

const todoListStore = useTodoListStore();
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;

// 기본 타입에 대해서는 계산된 속성을 다시 작성
const doneCount = computed(() => todoListStore.doneCount);

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>
