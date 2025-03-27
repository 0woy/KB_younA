<template>
  <div><Calc01 /></div>
  <hr />
  <div><Calc02 /></div>
  <hr />
  <div><Calc03 /></div>
  <hr />
  <div><Calc04 /></div>
  <hr />
  <div><Calc05 /></div>
</template>
<script>
import Calc01 from './components/Calc01.vue';
import Calc02 from './components/Calc02.vue';
import Calc03 from './components/Calc03.vue';
import Calc04 from './components/Calc04.vue';
import Calc05 from './components/Calc05.vue';
export default {
  name: 'App',
  components: { Calc01, Calc02, Calc03, Calc04, Calc05 },
};
</script>

<style scoped></style>
