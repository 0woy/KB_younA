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
<script>
export default {
  name: 'InputTodo',

  data() {
    return {
      title: '',
    };
  },
  methods: {
    addTodoHandler() {
      if (this.title.length >= 3) {
        this.$emit('add-todo', this.title);
        this.title = '';
      }
    },
  },
};
</script>
