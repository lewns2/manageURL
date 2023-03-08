import styled from 'styled-components';
import { theme } from '../../../../styles';

export const BoardPostWrapperStyle = styled.div`
  width: 80%;
  margin: auto;
`;

export const BoardPostContentWrapperStyle = styled.div`
  width: 100%;
`;

export const PostItemWrapperStyle = styled.div`
  cursor: pointer;
  background-color: ${theme.colors.GRAY};

  &:hover {
    background-color: gray;
  }
`;
