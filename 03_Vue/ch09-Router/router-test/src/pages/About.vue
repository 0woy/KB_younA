<template>
  <div class="card card-body">
    <h2>About</h2>
    <!-- <p>요청 경로: {{ $route.fullPath }}</p> -->
    <p>요청 경로: {{ route.fullPath }}</p>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
<script setup>
import { useRoute } from 'vue-router';

const route = useRoute();
// export default {
//   name: 'About',

//   //setup 함수 사용
//   setup() {
//     const route = useRoute();
//     return { route };
//   },
//   // // vue2
//   // created() {
//   //   console.log(this.$route);
//   // },
// };
</script>
