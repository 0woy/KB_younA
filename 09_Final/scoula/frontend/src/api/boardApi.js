import api from '@/api';
const BASE_URL = '/api/board';
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
  async getList(params) {
    const { data } = await api.get(BASE_URL, { params });

    return data;
  },

  async create(article) {
    const formData = new FormData();
    formData.append('title', article.title);
    formData.append('writer', article.writer);
    formData.append('content', article.content);

    if (article.files) {
      for (let i = 0; i < article.files.length; i++) {
        formData.append('files', article.files[i]);
      }
    }

    const { data } = await api.post(BASE_URL, formData, { headers });
    return data;
  },

  async get(no) {
    const { data } = await api.get(`${BASE_URL}/${no}`);
    return data;
  },

  async delete(no) {
    const { data } = await api.delete(`${BASE_URL}/${no}`);
    return data;
  },

  async update(article) {
    const formData = new FormData();
    formData.append('no', article.no);
    formData.append('title', article.title);
    formData.append('writer', article.writer);
    formData.append('content', article.content);

    if (article.files) {
      for (let i = 0; i < article.files.length; i++) {
        formData.append('files', article.files[i]);
      }
    }

    const { data } = await api.put(`${BASE_URL}/${article.no}`, formData, {
      headers,
    });
    return data;
  },

  // 첨부파일 삭제
  async deleteAttachment(no) {
    const { data } = await api.delete(`${BASE_URL}/deleteAttachment/${no}`);
    return data;
  },
};
