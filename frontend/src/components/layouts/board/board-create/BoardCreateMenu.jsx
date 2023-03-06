import { CommonBtn } from '../../../parts';

const BoardCreateMenu = ({ children, ...rest }) => {
  return (
    <>
      <CommonBtn {...rest}>{children}</CommonBtn>
    </>
  );
};

export default BoardCreateMenu;
