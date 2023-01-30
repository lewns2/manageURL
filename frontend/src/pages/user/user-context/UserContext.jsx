const { createContext } = require('react');

const initValue = {
  email: '',
  password: '',
};

export const UserContext = createContext(initValue);
