import { useContext } from 'react';
import { BoardCreateContext } from '../../create-context/CreateContext';

export default function useBoardCreateContext() {
  return useContext(BoardCreateContext);
}
