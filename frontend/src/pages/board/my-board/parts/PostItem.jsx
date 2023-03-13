import { Content } from '../../../../components/parts';
import { PostItemWrapper } from '../../../../components/layouts/board';
import { useNavigate } from 'react-router-dom';

const PostItem = ({ post }) => {
  const navigate = useNavigate();

  return (
    <PostItemWrapper>
      <Content onClick={() => navigate(`/board/${post.boardId}`, { state: { id: post.boardId } })}>
        {post.title}
      </Content>
    </PostItemWrapper>
  );
};

export default PostItem;
