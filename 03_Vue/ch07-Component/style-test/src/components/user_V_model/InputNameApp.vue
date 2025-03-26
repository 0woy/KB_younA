<template>
  <div>
    <InputName v-model:name="searchName" />
    <h3>검색어: {{ searchName }}</h3>
  </div>
</template>
<script>
import InputName from './InputName.vue';
export default {
  name: 'InputNameVue',
  components: { InputName },
  data() {
    return {
      searchName: 'John',
    };
  },
};
</script>
