import { PostItemWrapperStyle } from './MyBoard.styles';

const PostItemWrapper = ({ children, ...rest }) => {
  return (
    <>
      <PostItemWrapperStyle {...rest}>{children}</PostItemWrapperStyle>
    </>
  );
};

export default PostItemWrapper;
