<template>
  <div>
    <slot name="icon"></slot>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('checked-change', { id, checked: $event.target.checked })"
    />
    <slot name="label"></slot>
  </div>
</template>
<script>
export default {
  name: 'CheckBox3',
  props: ['id', 'checked'],
};
</script>
