<template>
  <div class="gallery-item">
    <li>
      <img
        :src="img.src"
        :value="img.id"
        class="pointer"
        @click="$emit('item-clicked', img)"
      />
    </li>
  </div>
</template>
<script>
export default {
  name: 'GalleyListItem',
  props: ['img'],
};
</script>
<style scoped>
.gallery-item {
  display: inline-block;
  width: 150px;
  height: 150px;
  justify-content: center;
  align-items: center;
  list-style: none;
}
img {
  width: 100%; /* 부모 크기에 맞춤 */
  height: 100%;
  object-fit: cover; /* 비율 유지하며 채우기 */
  cursor: pointer;
  border-radius: 8px;
}
</style>
