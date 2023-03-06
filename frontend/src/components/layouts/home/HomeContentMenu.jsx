import { CommonBtn, Content } from '../../parts';

const HomeContentMenu = ({ children, ...rest }) => {
  return (
    <CommonBtn {...rest}>
      <Content>{children}</Content>
    </CommonBtn>
  );
};

export default HomeContentMenu;
