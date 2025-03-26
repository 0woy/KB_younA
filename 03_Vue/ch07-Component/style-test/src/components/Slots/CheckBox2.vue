<template>
  <div>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('checked-changed', { id, checked: $event.target.checked })"
    />
    <slot>Item</slot>
  </div>
</template>
<script>
export default {
  name: 'CheckBox2',
  props: ['id', 'checked'],
};
</script>
