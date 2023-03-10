import styled from '@emotion/styled';
import theme from '../../../styles/theme';

export const SideSection = styled.section`
  position: relative;
  width: 15%;
  height: 100vh;
  background: ${theme.colors.WHITE};
  box-shadow: 0 4px 4px rgba(0, 0, 0, 0.15);
  z-index: 0;
`;

export const MenuWrapper = styled.ul`
  justify-content: space-between;
`;

export const Menu = styled.li`
  cursor: pointer;
  color: ${theme.colors.GRAY};
  fill: ${theme.colors.GRAY};

  &:focus,
  $:hover,
  &:active {
  }

  &:hover {
    color: ${theme.colors.BLACK};
    fill: ${theme.colors.BLACK};
  }
`;
