<template>
  <h2>최신 인기곡</h2>
  <SongList :songs="songs" />
  <!-- <ul>
    <SongListItem v-for="s in songs" :key="s.id" :song="s" /> 
   </ul> -->
</template>
<script>
/** yoonA younA see bangawoyo; */
import { computed } from 'vue';
import SongList from './SongList.vue';
export default {
  name: 'Main',
  components: { SongList },
  data() {
    return {
      songs: [
        { id: 1, title: 'Blueming', done: true },
        { id: 2, title: 'Attitude', done: true },
        { id: 3, title: '못 죽는 기사와 비단 요람', done: false },
        { id: 4, title: '마리아', done: false },
      ],
    };
  },
  provide() {
    return {
      icons: {
        checked: 'far fa-check-circle',
        unchecked: 'far fa-circle',
      },
      doneCount: computed(() => {
        return this.songs.filter((s) => s.done === true).length;
      }),
    };
  },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
