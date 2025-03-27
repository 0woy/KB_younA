<template>
  <div class="gallery-list">
    <GalleryListItem
      v-for="img in images"
      :key="img.id"
      :img="img"
      @item-clicked="handleItemClick"
    />
  </div>
</template>
<script>
import GalleryListItem from './GalleryListItem.vue';
export default {
  name: 'GalleyList',
  components: { GalleryListItem },
  props: ['images'],
  methods: {
    handleItemClick(img) {
      this.$emit('item-clicked', img);
    },
  },
};
</script>
<style scoped>
.gallery-list {
  display: flex;
  gap: 10px;
  justify-content: flex-start;
  align-items: flex-start;
}
</style>
