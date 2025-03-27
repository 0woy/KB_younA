<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoItem.completed }"
    @click="$emit('toggle-completed', todoItem.id)"
  >
    <span class="pointer" :class="{ 'todo-done': todoItem.completed }"
      >{{ todoItem.title }} {{ todoItem.completed ? '(완료)' : '' }}</span
    >
    <span
      class="float-end badge bg-secondary pointer"
      @click="$emit('deleteItem', todoItem.id)"
      >삭제</span
    >
  </li>
</template>
<script>
export default {
  name: 'TodoListItem',
  props: ['todoItem'],
  emits: ['deleteItem', 'toggle-completed'],
};
</script>
