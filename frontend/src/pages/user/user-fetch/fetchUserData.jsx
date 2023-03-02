const baseUrl = 'http://localhost:8080/api';

/* 회원 가입 */
const signUp = async (data) => {
  const res = await fetch(`${baseUrl}/signup`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });

  const resData = await res.json();

  return resData;
};

/* 로그인 */
const login = async (data) => {
  const res = fetch(`${baseUrl}/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });

  const resData = await res.json();

  return resData;
};

export const fetchUserData = {
  login,
  signUp,
};

export default fetchUserData;
