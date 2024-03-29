import { ENDPOINTS, METHOD, HEADERS } from '../../../constants/api';

const userApi = {
  /* 회원 가입 */
  signUp: async (data) => {
    const res = await fetch(ENDPOINTS.SIGNUP, {
      method: METHOD.POST,
      headers: HEADERS.JSON,
      body: JSON.stringify(data),
    });

    const resData = await res.json();

    return resData;
  },

  /* 로그인 */
  login: async (data) => {
    const res = await fetch(ENDPOINTS.LOGIN, {
      method: METHOD.POST,
      headers: HEADERS.JSON,
      body: JSON.stringify(data),
    });

    const resData = await res.json();

    return resData;
  },

  /* 닉네임 중복 확인 */
  checkNickName: async (data) => {
    const res = await fetch(ENDPOINTS.CHECK_NICKNAME(data), {
      method: METHOD.GET,
    });

    const resData = await res.json();

    return resData;
  },
};

export default userApi;
