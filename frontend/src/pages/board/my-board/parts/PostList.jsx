import { SubTitle } from '../../../../components/parts';
import PostItem from './PostItem';

const PostList = ({ resource }) => {
  const postList = resource.read();
  const postListLength = postList.countBoards;
  const postListDate = Object.keys(postList.boardsGroupByDate);

  return (
    <>
      <SubTitle>총 {postListLength}개의 포스트를 작성했어요!</SubTitle>

      {postListDate.map((date, index) => (
        <div key={index}>
          <SubTitle>{date}</SubTitle>
          {postList.boardsGroupByDate[`${date}`].map((post, index) => (
            <PostItem key={index} post={post}></PostItem>
          ))}
        </div>
      ))}
    </>
  );
};

export default PostList;
