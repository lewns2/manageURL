import styled from '@emotion/styled';

const ButtonStyle = styled.button`
  background-color: white;
  border: 1px solid;
  border-radius: 10px;
  border-color: black;
  padding: 5px;
  font-weight: bold;
  box-shadow: 1px 2px 2px 2px rgb(0 0 0 / 25%);
  cursor: pointer;
`;

const FormBtn = ({ children, ...rest }) => {
  return <ButtonStyle {...rest}>{children}</ButtonStyle>;
};

export default FormBtn;
