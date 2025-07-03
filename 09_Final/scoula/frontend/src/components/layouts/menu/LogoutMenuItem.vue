<script setup>
import { useAuthStore } from '@/stores/auth';
import { useRouter } from 'vue-router';

const router = useRouter();
const store = useAuthStore();
const logout = (e) => {
  if (!confirm('로그아웃 하시겠습니까?')) return;
  store.logout();
  router.push('/');
};
</script>

<template>
  <a href="#" class="nav-link" @click.prevent="logout">
    <i class="fa-solid fa-right-bracket"></i>
    로그아웃
  </a>
</template>
