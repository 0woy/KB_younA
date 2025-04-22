<template>
  <div>
    <input
      type="text"
      :value="search"
      @input="$emit('update:search', $event.target.value)"
    />
  </div>
</template>
<script>
export default {
  name: 'InputName',
  props: ['search'],
};
</script>
