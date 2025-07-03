import { useAuthStore } from '@/stores/auth';

export const isAuthenticated = (to, from) => {
  const auth = useAuthStore();

  if (!auth.isLogin) {
    alert('로그인 필요');
    return { name: 'login', query: { next: to.name } };
  }
  console.log('로그인 인증');
};
