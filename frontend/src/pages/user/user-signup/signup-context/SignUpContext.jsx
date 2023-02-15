const { createContext } = require('react');

const initValue = {
  nickName: '',
  email: '',
  password: '',
};

export const SignUpContext = createContext(initValue);
