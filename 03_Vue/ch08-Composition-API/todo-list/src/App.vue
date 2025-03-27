<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">::TodoList App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todolist="state.todolist"
          @delete-todo="deleteTodo"
          @toggle-completed="toggle_completed"
        />
      </div>
    </div>
  </div>
</template>
<script setup>
import { onMounted, reactive } from 'vue';
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
const ts = new Date().getTime();
let state = reactive({ todolist: [] });

onMounted(() => {
  state.todolist.push({ id: ts, title: '안산 놀러 가기', completed: true });
  state.todolist.push({ id: ts + 1, title: '책 읽기', completed: false });
  state.todolist.push({
    id: ts + 2,
    title: '두리랑 뽀뽀하기',
    completed: false,
  });
  state.todolist.push({
    id: ts + 3,
    title: '스터디 준비하기',
    completed: false,
  });
});

const addTodo = (title) => {
  if (title.length >= 2) {
    state.todolist.push({
      id: new Date().getTime,
      title: title,
      completed: false,
    });
  }
};

const deleteTodo = (idx) => {
  let item = state.todolist.findIndex((item) => item.id === idx);
  state.todolist.splice(item, 1);
};

const toggle_completed = (idx) => {
  let index = state.todolist.findIndex((item) => item.id === idx);
  state.todolist[index].completed = !state.todolist[index].completed;
};
</script>
