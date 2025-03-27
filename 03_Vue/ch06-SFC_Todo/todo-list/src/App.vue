<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">::TodoList App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todolist="todolist"
          @delete-todo="deleteTodo"
          @toggle-completed="toggle_completed"
        />
      </div>
    </div>
  </div>
</template>
<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
const ts = new Date().getTime();
export default {
  name: 'App',
  components: { TodoList, InputTodo },

  data() {
    return {
      todolist: [
        { id: ts, title: '안산 놀러 가기', completed: true },
        { id: ts + 1, title: '책 읽기', completed: false },
        { id: ts + 2, title: '두리랑 뽀뽀하기', completed: false },
        { id: ts + 3, title: '스터디 준비하기', completed: false },
      ],
    };
  },
  methods: {
    addTodo(title) {
      if (title.length >= 2) {
        this.todolist.push({
          id: new Date().getTime,
          title: title,
          completed: false,
        });
      }
    },
    deleteTodo(idx) {
      let item = this.todolist.findIndex((item) => item.id === idx);
      this.todolist.splice(item, 1);
    },
    toggle_completed(idx) {
      let index = this.todolist.findIndex((item) => item.id === idx);
      this.todolist[index].completed = !this.todolist[index].completed;
    },
  },
};
</script>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
