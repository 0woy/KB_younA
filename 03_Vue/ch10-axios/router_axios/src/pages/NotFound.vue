<template>
  <div class="mt-3">
    <h3>존재하지 않는 경로</h3>
    <p>요청 경로: {{ path }}</p>
  </div>
</template>
<script setup>
import { useRoute } from 'vue-router';

const { path } = useRoute();
</script>
