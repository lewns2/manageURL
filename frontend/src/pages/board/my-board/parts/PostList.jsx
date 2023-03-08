import { SubTitle } from '../../../../components/parts';
import PostItem from './PostItem';

const PostList = ({ resource }) => {
  const postList = resource.read();

  return (
    <>
      <SubTitle>총 {postList.length}개의 포스트를 작성했어요!</SubTitle>

      {postList &&
        postList.map((post, index) => (
          <div key={index}>
            <PostItem post={post}></PostItem>
          </div>
        ))}
    </>
  );
};

export default PostList;
