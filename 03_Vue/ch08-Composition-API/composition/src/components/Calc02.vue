<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    Y : <input type="text" v-model.number="y" /> <br />
    <button @click="calAdd">계산</button>
    <div>결과 {{ result }}</div>
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc02',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);

    const calAdd = () => {
      result.value = x.value + y.value;
    };

    return { x, y, result, calAdd };
  },
};
</script>
