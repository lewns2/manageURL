const { createContext } = require('react');

const initValue = {
  nickName: '',
  email: '',
  password: '',
  check: {
    nickName: false,
  },
};

export const SignUpContext = createContext(initValue);
