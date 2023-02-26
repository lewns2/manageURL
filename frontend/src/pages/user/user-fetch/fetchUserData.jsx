const baseUrl = 'http://localhost:8080/api/';

/* 회원 가입 */
function fetchSignUp(data) {
  let isSuccess = false;

  const suspender = fetch(`${baseUrl}/signup`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      data,
    }),
  }).then((response) => response.json());

  return {
    read() {
      if (isSuccess === false) {
        throw suspender;
      } else {
        return isSuccess;
      }
    },
  };
}

/* 로그인 */
function fetchLogin(data) {
  let isSuccess = false;

  const suspender = fetch(`${baseUrl}/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      data,
    }),
  }).then((response) => response.json());

  return {
    read() {
      if (isSuccess === false) {
        throw suspender;
      } else {
        return isSuccess;
      }
    },
  };
}

function fetchUserData(userData) {
  return {
    signup: fetchSignUp(userData),
    login: fetchLogin(userData),
  };
}

export default fetchUserData;
