<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할 일을 입력!"
          id="msg"
          name="msg"
          v-model.trim="title"
          @keyup.enter="addTodoHandler"
        />
        <span class="btn btn-primary input-group-addon" @click="addTodoHandler"
          >추가</span
        >
      </div>
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue';
const emit = defineEmits(['add-todo']);
const title = ref('');

const addTodoHandler = () => {
  if (title.value.length >= 3) {
    emit('add-todo', title.value);
    title.value = '';
  }
};
</script>
