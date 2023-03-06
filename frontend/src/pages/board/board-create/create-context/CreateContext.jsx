import { createContext } from 'react';

const initValue = {
  title: '',
  description: '',
  urls: [],
};

export const BoardCreateContext = createContext(initValue);
