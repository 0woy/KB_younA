<template>
  <Layout>
    <template v-slot:header>
      <headerSect />
    </template>
    <template v-slot:sidebar>
      <sidebar />
    </template>
    <template v-slot:default>
      <content />
    </template>
    <template v-slot:footer>
      <footerSect />
    </template>
  </Layout>
</template>
<script>
import Layout from './Layout.vue';
import sidebar from './sidebar.vue';
import content from './content.vue';
import headerSect from './headerSect.vue';
import footerSect from './footerSect.vue';

export default {
  name: 'LayoutApp',
  components: { Layout, headerSect, sidebar, content, footerSect },
};
</script>
