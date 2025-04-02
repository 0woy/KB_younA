<template>
  <div v-for="item in items" :key="item.id">
    <slot name="icon" :checked="item.checked"></slot>
    <input
      type="checkbox"
      :value="id"
      :checked="item.checked"
      @change="
        $emit('checked-change', { id: item.id, checked: $event.target.checked })
      "
    />
    <slot name="label" :checked="item.checked" :label="item.label"></slot>
  </div>
</template>
<script>
export default {
  name: 'CheckBoxList',
  props: ['items'],
};
</script>
