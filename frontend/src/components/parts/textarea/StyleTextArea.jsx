import styled from '@emotion/styled';

const CommonTextAreaStyle = styled.textarea`
  background-color: white;
  border: 1px solid;
  border-radius: 3px;
  border-color: black;
  padding: 5px;
  font-weight: bold;
  box-shadow: 1px 2px 2px 2px rgb(0 0 0 / 25%);
`;

const StyleTextArea = ({ children, ...rest }) => {
  return <CommonTextAreaStyle {...rest}>{children}</CommonTextAreaStyle>;
};

export default StyleTextArea;
