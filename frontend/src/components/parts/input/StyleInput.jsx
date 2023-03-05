import styled from '@emotion/styled';

const CommonInputStyle = styled.input`
  background-color: white;
  border: 1px solid;
  border-radius: 3px;
  border-color: black;
  padding: 5px;
  font-weight: bold;
  box-shadow: 1px 2px 2px 2px rgb(0 0 0 / 25%);
`;

const StyleInput = ({ children, ...rest }) => {
  return <CommonInputStyle {...rest}>{children}</CommonInputStyle>;
};

export default StyleInput;
