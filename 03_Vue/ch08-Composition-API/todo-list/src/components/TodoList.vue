<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="item in todolist"
          :key="item.id"
          :todoItem="item"
          @deleteItem="emit('delete-todo', item.id)"
          @toggle-completed="emit('toggle-completed', item.id)"
        />
      </ul>
    </div>
  </div>
</template>
<script setup>
import TodoListItem from './TodoListItem.vue';
const props = defineProps({
  todolist: { type: Array, required: true },
});
const emit = defineEmits(['delete-todo', 'toggle-completed']);
</script>
