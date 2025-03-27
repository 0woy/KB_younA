<template>
  <div class="gallery-container">
    <GalleryView :selectedImg="selectedImg" />
    <GalleryList :images="images" @item-clicked="updateSelectImg" />
  </div>
</template>
<script>
import GalleryView from './GalleryView.vue';
import GalleryList from './GalleryList.vue';
import { computed } from 'vue';
export default {
  name: 'Galley',
  components: { GalleryView, GalleryList },
  data() {
    return {
      images: [
        { id: 1, src: './images/img1.jpg', title: '귀여운 짱구' },
        { id: 2, src: './images/img2.jpg', title: '짱구와 칭구들' },
        { id: 3, src: './images/img3.jpg', title: '개굴 짱구' },
        { id: 4, src: './images/img4.jpg', title: '직장인 짱구' },
        { id: 5, src: './images/img5.jpg', title: '슬픈 짱구' },
        { id: 6, src: './images/img6.jpg', title: '인어구' },
      ],
      selectedImg: '',
    };
  },
  mounted() {
    this.selectedImg = this.images[2];
  },
  provide() {
    return {
      selectedImg: computed(() => {
        return this.selectedImg;
      }),
    };
  },

  methods: {
    updateSelectImg(img) {
      this.selectedImg = img;
    },
  },
};
</script>
<style scoped>
.gallery-container {
  display: flex;
  flex-direction: column;
  justify-content: center; /* 세로 중앙 */
  align-items: center; /* 가로 중앙 */
  min-height: 100vh; /* 화면 전체 높이에서 중앙 정렬 */
  text-align: center;
}
</style>
