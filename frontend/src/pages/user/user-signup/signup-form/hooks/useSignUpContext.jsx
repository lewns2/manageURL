import { useContext } from 'react';
import { SignUpContext } from '../../signup-context/SignUpContext';

export default function useSignUpContext() {
  return useContext(SignUpContext);
}
