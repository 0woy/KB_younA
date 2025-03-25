<template>
  <li><input type="checkbox" v-model="checked" />option 1</li>
</template>
<script>
export default {
  name: 'checkboxItem',
  data() {
    return {
      checked: true,
    };
  },
};
</script>
