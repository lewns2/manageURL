import styled from '@emotion/styled';
import theme from '../../../styles/theme';

const ButtonStyle = styled.button`
  background-color: ${theme.colors.GRAY};
  border: 1px solid;
  border-radius: 5px;
  border-color: ${theme.colors.GRAY};
  padding: 5px;
  box-shadow: 1px 2px 2px 2px rgb(0 0 0 / 10%);
`;

const CommonBtn = ({ children, ...rest }) => {
  return <ButtonStyle {...rest}>{children}</ButtonStyle>;
};

export default CommonBtn;
