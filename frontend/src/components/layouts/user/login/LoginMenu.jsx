import { CommonBtn } from '../../../parts';

const LoginMenu = ({ children, ...rest }) => {
  return (
    <>
      <CommonBtn {...rest}>{children}</CommonBtn>
    </>
  );
};

export default LoginMenu;
