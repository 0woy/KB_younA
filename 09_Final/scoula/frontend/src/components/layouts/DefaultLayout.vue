<script setup>
import Header from './Header.vue';
import NavBar from './Navbar.vue';
import Footer from './Footer.vue';
</script>
<template>
  <!-- container: 중앙 정렬, 없애면 가로로 꽉 참 -->
  <div class="container">
    <Header />
    <NavBar />
    <div class="content my-5 px-3">
      <!-- 부모가 결정하는 slot -->
      <slot></slot>
    </div>
    <Footer />
  </div>
</template>
