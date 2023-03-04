export const BASE_URL = 'http://localhost:8080/api';

export const METHOD = {
  GET: 'GET',
  POST: 'POST',
  PUT: 'PUT',
  PATCH: 'PATCH',
  DELETE: 'DELETE',
};

export const HEADERS = {
  JSON: { 'Content-Type': 'application/json' },
};

export const ENDPOINTS = {
  POST: `${BASE_URL}/board`,
  POST_BY_ID: (id) => `${BASE_URL}/board/${id}`,
  MY_POSTS: (nickName) => `${BASE_URL}/board/${nickName}`,

  MY_URLS: (nickName) => `${BASE_URL}/urls/${nickName}`,

  SIGNUP: `${BASE_URL}/signup`,
  LOGIN: `${BASE_URL}/login`,
};
