import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import MemeberInfo from '@/pages/MemeberInfo.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: Home,
    },
    {
      path: '/about',
      component: () => import('../pages/About.vue'),
    },
    {
      path: '/members',
      component: () => import('../pages/Members.vue'),
    },
    {
      path: '/members/:id',
      component: MemeberInfo,
    },
    {
      path: '/videos',
      component: () => import('../pages/Videos.vue'),
    },
  ],
});

export default router;
