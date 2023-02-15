const { createContext } = require('react');

const initValue = {
  email: '',
  password: '',
};

export const LoginContext = createContext(initValue);
