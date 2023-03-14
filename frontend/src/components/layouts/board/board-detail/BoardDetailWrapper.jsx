import { DetailWrapperStyle } from './BoardDetail.styles';

const BoardDetailWrapper = ({ children }) => {
  return (
    <>
      <DetailWrapperStyle>{children}</DetailWrapperStyle>
    </>
  );
};

export default BoardDetailWrapper;
