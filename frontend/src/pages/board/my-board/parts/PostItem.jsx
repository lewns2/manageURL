import { Content } from '../../../../components/parts';
import { PostItemWrapper } from '../../../../components/layouts/board';

const PostItem = ({ post }) => {
  return (
    <PostItemWrapper>
      <Content>{post.title}</Content>
    </PostItemWrapper>
  );
};

export default PostItem;
