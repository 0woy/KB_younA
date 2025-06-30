import axios from 'axios';
import { useAuthStore } from '@/stores/auth';
import router from '@/router';

const instance = axios.create({
  timeout: 1000,
});

// 요청 인터셉터
instance.interceptors.request.use(
  (config) => {
    // jwt 추출
    const { getToken } = useAuthStore();
    const token = getToken();

    // 토큰이 있는 경우
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
      console.log(config.headers.Authorization);
    }
    return config;
  },
  // 요청 중 에러 발생
  (error) => {
    return Promise.reject(error);
  }
);

instance.interceptors.response.use(
  // 정상 응답인 경우
  (response) => {
    if (response.status === 200) {
      return response;
    }
    if (response.status === 404) {
      return Promise.reject('404: 페이지 없음 ' + response.request);
    }
    return response;
  },

  // 에러 응답: 401, 403, 500, 305
  async (error) => {
    if (error.response?.status === 401) {
      const { logout } = useAuthStore();
      logout();
      router.push('/auth/login?error=login_required');
      return Promise.reject({ error: '로그인이필요한서비스입니다.' });
    }
    return Promise.reject(error);
  }
);
export default instance; // 인터셉터가 적용된 axios 인스턴스
