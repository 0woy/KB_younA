<template>
  <div id="app" class="container">
    <Header />
    <router-view />
    <Loading v-if="isLoading" />
  </div>
</template>

<script setup>
import { computed } from 'vue';
import Header from './components/Header.vue';
import Loading from './components/Loading.vue';
import { useTodoListStore } from './stores/todoList';

const todoListStore = useTodoListStore();
const isLoading = computed(() => todoListStore.isLoading);
const fetchTodoList = todoListStore.fetchTodoList;
fetchTodoList();
</script>
