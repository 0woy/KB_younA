<template>
  <div>
    <GalleryView :selectedImg="selectedImg" />
  </div>
  <div>
    <GalleryList @item-clicked="handleClickedImg" />
  </div>
</template>
<script>
import GalleryView from './GalleryView.vue';
import GalleryList from './GalleryList.vue';
export default {
  name: 'Galley',
  components: { GalleryView, GalleryList },
  data() {
    return {
      selectedImg: '',
    };
  },
  provide() {
    return {
      images: [
        { id: 1, img: './images/img1.jpg', title: '째려보는 강아지' },
        { id: 2, img: './images/img2.jpg', title: '늘어져있는 강아지' },
        { id: 3, img: './images/img3.jpg', title: '날 바라보는 강아지' },
        { id: 4, img: './images/img4.jpg', title: '새침한 강아지' },
        { id: 5, img: './images/img5.jpg', title: '먼 곳을 바라보는 강아지' },
        { id: 6, img: './images/img6.jpg', title: '포즈를 취하는 강아지' },
        { id: 7, img: './images/img7.jpg', title: '밥그릇에 들어간 강아지' },
      ],
    };
  },
  mounted() {
    // 컴포넌트가 마운트 된 후 selectedImg 적용
    this.selectedImg = this.$options.provide().images[6];
  },
  methods: {
    handleClickedImg(img) {
      console.log(img.img.id);
      this.selectedImg = this.$options.provide().images[img.img.id];
      console.log(this.selectedImg);
    },
  },
};
</script>
