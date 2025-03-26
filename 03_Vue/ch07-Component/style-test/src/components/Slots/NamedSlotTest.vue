<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은 (명명 슬롯)</h3>
    <CheckBox3
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :checked="item.checked"
      @checked-change="CheckBoxChanged"
    >
      <template v-slot:icon>
        <i v-if="item.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-frown"></i>
      </template>
      <template v-slot:label>
        <span
          v-if="item.checked"
          style="color: blue; text-decoration: underline"
          >{{ item.label }}</span
        >
        <span v-else style="color: gray">{{ item.label }}</span>
      </template>
    </CheckBox3>
  </div>
</template>
<script>
import CheckBox3 from './CheckBox3.vue';
export default {
  name: 'NamedSlotTest',
  components: { CheckBox3 },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      let item = this.items.find((item) => item.id === e.id);
      item.checked = !item.checked;
    },
  },
};
</script>
