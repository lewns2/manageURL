import styled from '@emotion/styled';

const CommonTextAreaStyle = styled.textarea`
  background-color: white;
  border-radius: 5px;
  padding: 10px;
  font-weight: bold;
  box-shadow: 0 10px 15px -3px rgb(0 0 0 / 0.1);
  width: 100%;
  resize: none;
  height: 500px;
  overflow-y: auto;
  overflow-x: hidden;
  white-space: pre-wrap;
  border-style: solid;
  border-color: #e5e7eb;
`;

const StyleTextArea = ({ children, ...rest }) => {
  return (
    <CommonTextAreaStyle {...rest} placeholder="내용을 입력해주세요">
      {children}
    </CommonTextAreaStyle>
  );
};

export default StyleTextArea;
