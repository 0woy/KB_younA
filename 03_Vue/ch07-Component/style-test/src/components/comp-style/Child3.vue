<template>
  <!-- <div :class="$style.child"> -->
  <div :class="$style.child">
    <h2>child3</h2>
  </div>
</template>
<script>
export default {
  name: 'Child3',
  created() {
    console.log(this.$style);
  },
};
</script>
<style module>
.child {
  background-color: aqua;
  border: solid 1px, black;
  margin: 1.5em;
  padding: 1em;
}
</style>
