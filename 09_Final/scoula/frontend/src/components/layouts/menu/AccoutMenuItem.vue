<script setup>
const props = defineProps({ username: String });
const avatar = `/api/member/${props.username}/avatar`;
</script>
<template>
  <li class="nav-item">
    <router-link class="nav-link" to="/auth/profile">
      <img :src="avatar" class="avatar avatar-sm" />
      <!-- <i class="fa-solid fa-user"></i> -->
      {{ username }}
    </router-link>
  </li>
</template>
