<script setup>
import Gallery from './components/Gallery.vue';
</script>

<template>
  <div class="center-container">
    <Gallery />
  </div>
</template>

<style scoped>
.center-container {
  display: flex;
  justify-content: center; /* 가로 중앙 정렬 */
  align-items: center; /* 세로 중앙 정렬 */
  height: 100vh; /* 화면 전체 높이 */
  width: 100%; /* 부모 div가 전체 너비를 차지 */
}
</style>
