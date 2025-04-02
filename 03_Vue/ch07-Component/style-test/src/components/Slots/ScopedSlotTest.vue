<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은 (범위 슬롯)</h3>
    <CheckBoxList :items="items" @checked-change="CheckBoxChanged">
      <template v-slot:icon="p1">
        <i v-if="p1.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-frown"></i>
      </template>
      <template v-slot:label="p2">
        <span
          v-if="p2.checked"
          style="color: blue; text-decoration: underline"
          >{{ p2.label }}</span
        >
        <span v-else style="color: gray">{{ p2.label }}</span>
      </template>
    </CheckBoxList>
  </div>
</template>
<script>
import CheckBoxList from './CheckBoxList.vue';
export default {
  name: 'ScopedSlot',
  components: { CheckBoxList },
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
