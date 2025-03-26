<template>
  <div>
    <img :src="selectedImg.img" />
  </div>
</template>
<script>
export default {
  name: 'GalleyView',
  props: ['selectedImg'],
};
</script>
