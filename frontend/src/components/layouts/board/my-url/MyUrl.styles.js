import styled from 'styled-components';
import theme from '../../../../styles/theme';
export const BoardUrlWrapperStyle = styled.div`
  width: 80%;
  margin: auto;
`;

export const UrlContainerStyle = styled.div`
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  padding: 40px;
`;

export const UrlItemStyle = styled.div`
  width: calc(25% - (60px / 4));
  box-sizing: border-box;
  border-radius: 10px;
  box-shadow: 4px 0px 5px 2px rgba(0, 0, 0, 0.15);
  padding: 20px;
`;

export const ItemUrlStyle = styled.div`
  cursor: pointer;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
  color: ${theme.colors.GRAY}};
  fill: ${theme.colors.GRAY};

  &:hover {
    overflow: visible;
    color: ${theme.colors.BLACK};
    fill: ${theme.colors.BLACK};
  }
`;

export const ItemCategoryStyle = styled.div`
  margin-top: 5px;
  height: 39px;
`;

export const ItemPostStyle = styled.div`
  padding-top: 10%;
`;
