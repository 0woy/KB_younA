<template>
  <!-- <ScopedSlotTest /> -->
  <!-- <Child1 />
  <Child2 />
  <Child3 /> -->

  <!-- <hr />
  <NoSlotTest />
  <hr />
  <SlotTest />
  <hr />
  <NamedSlotTest />
  <hr /> -->
  <!-- <InputNameApp /> -->
  <hr />
  <!-- <Main /> -->
  <!-- <hr />
  <LayoutApp />  -->
  <InputNameApp />
</template>

<script>
import Child1 from './components/comp-style/Child1.vue';
import Child2 from './components/comp-style/Child2.vue';
import Child3 from './components/comp-style/Child3.vue';
import NoSlotTest from './components/Slots/NoSlotTest.vue';
import SlotTest from './components/Slots/SlotTest.vue';
import ScopedSlotTest from './components/Slots/ScopedSlotTest.vue';
import InputNameApp from './components/user_V_model/InputNameApp.vue';
import Main from './components/Provide_Inject/Main.vue';
import NamedSlotTest from './components/Slots/NamedSlotTest.vue';
import LayoutApp from './components/Layout/LayoutApp.vue';
export default {
  name: 'App',
  components: {
    Child1,
    Child2,
    Child3,
    NoSlotTest,
    SlotTest,
    InputNameApp,
    Main,
    NamedSlotTest,
    LayoutApp,
    ScopedSlotTest,
  },
};
</script>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
