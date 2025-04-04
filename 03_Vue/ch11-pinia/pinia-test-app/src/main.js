import { createApp } from 'vue';
import { createPinia } from 'pinia';
import App2 from './App2.vue';

const app = createApp(App2);

app.use(createPinia());

app.mount('#app');
