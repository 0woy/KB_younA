<template>
  <div>
    <InputName @nameChanged="nameChangeHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>
<script>
import InputName from './components/InputName.vue';
export default {
  name: 'App2',
  component: { InputName },
  data() {
    return { parentName: 'adg' };
  },
  methods: {
    nameChangeHandler(e) {
      this.parentName = e.name;
    },
  },
};
</script>
