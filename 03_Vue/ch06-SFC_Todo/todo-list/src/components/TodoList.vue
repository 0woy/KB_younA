<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="item in todolist"
          :key="item.id"
          :todoItem="item"
          @deleteItem="$emit('delete-todo', $event)"
          @toggle-completed="$emit('toggle-completed', $event)"
        />
      </ul>
    </div>
  </div>
</template>
<script>
import TodoListItem from './TodoListItem.vue';
export default {
  name: 'TodoList',
  props: ['todolist'],
  components: { TodoListItem },

  emits: ['delete-todo', 'toggle-completed'],
};
</script>
