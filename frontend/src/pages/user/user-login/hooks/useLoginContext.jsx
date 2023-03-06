import { useContext } from 'react';
import { LoginContext } from '../login-context/LoginContext';

export default function useSignUpContext() {
  return useContext(LoginContext);
}
