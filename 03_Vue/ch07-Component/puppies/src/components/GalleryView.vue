<template>
  <div class="selected-img">
    <h1>{{ selectedImg.title }}</h1>
    <img :src="selectedImg?.src" />
  </div>
</template>
<script>
export default {
  name: 'GalleyView',
  inject: ['selectedImg'],
};
</script>
<style scoped>
.selected-img {
  width: 100%;
  margin-bottom: 30px;
  height: auto;
}
img {
  width: 500px;
  height: 100%;
  border-radius: 8px;
}
</style>
