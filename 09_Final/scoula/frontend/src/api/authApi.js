const BASE_URL = '/api/member';
const headers = { 'Content-Type': 'multipart/form-data' };
import api from '@/api';
import auth from '@/router/auth';

export default {
  async checkUsername(username) {
    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log('AUTH GET CHECKUSERNAME: ', data);
    return data;
  },

  async create(member) {
    // 아바타 파일 업로드
    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password);

    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    const { data } = await api.post(BASE_URL, formData, headers);

    console.log('AUTH POST: ', data);
    return data;
  },

  async update(member) {
    console.log('member: ', member);

    const formData = new FormData();
    formData.append('username', member.username);
    formData.append('password', member.password);
    formData.append('email', member.email);
    if (member.avatar) {
      formData.append('avatar', member.avatar);
    }

    console.log('--- FormData Contents ---');
    for (let pair of formData.entries()) {
      console.log(pair[0] + ': ' + pair[1]);
    }
    console.log('--- End FormData Contents ---');

    const { data } = await api.put(
      `${BASE_URL}/${member.username}`,
      formData,
      headers
    );

    console.log('AUTH PUT: ', data);
    return data;
  },
  async changePassword(formData) {
    const { data } = await api.put(
      `${BASE_URL}/${formData.username}/changepassword`,
      formData
    );
    console.log('AUTH PUT: ', data);
    return data;
  },
};
