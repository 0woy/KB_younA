<script setup>
import { computed } from 'vue';
import MenuItem from './MenuItem.vue';
import AccoutMenuItem from './AccoutMenuItem.vue';
import LogoutMenuItem from './LogoutMenuItem.vue';
import config from '@/config';

const { login, join } = config.accoutMenus;

const isLogin = computed(() => false); //임시 : 로그인 하지 않음
const username = computed(() => ''); //임시 : 사용자 명 없음
</script>

<template>
  <ul class="navbar-nav ms-auto">
    <template v-if="isLogin">
      <AccoutMenuItem :username="username" />
    </template>
    <template v-else>
      <MenuItem :menu="login" />
      <MenuItem :menu="join" />
    </template>
  </ul>
</template>
