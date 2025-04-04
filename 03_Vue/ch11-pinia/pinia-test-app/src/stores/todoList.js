import { computed, reactive } from 'vue';

import { defineStore } from 'pinia';

export const useTodoListStore = defineStore('todoList', () => {
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6학습', done: false },
      { id: 2, todo: 'React학습', done: false },
      { id: 3, todo: 'ContextAPI 학습', done: true },
      { id: 4, todo: '야구경기 관람', done: false },
    ],
  });

  //action
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };

  const deleteTodo = (id) => {
    let idx = state.todoList.forEach((item) => item.id === id);
    state.todoList.splice(idx, 1);
  };
  const toggleDone = (id) => {
    let idx = state.todoList.forEach((item) => item.id === id);
    state.todoList[idx].done = !state.todoList[idx].done;
  };
  const doneCount = computed(() => {
    return state.todoList.filter((item) => item.done === true).length;
  });

  const todoList = computed(() => state.todoList);
  return { todoList, addTodo, deleteTodo, toggleDone, doneCount };
});
