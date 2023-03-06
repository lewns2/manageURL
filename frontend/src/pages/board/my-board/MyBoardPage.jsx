import { Suspense } from 'react';
import { boardApi } from '../board-api';
import { LayoutWithSideMenu } from '../../../components/layouts/common';

const MyBoardPage = () => {
  return (
    <div>
      <LayoutWithSideMenu>
        <h2>나의 게시글 컴포넌트</h2>
        <Suspense fallback={<p>게시글 불러오는 중...</p>}>
          <PostList resource={boardApi.fetchPosts(localStorage.getItem('nickName'))}></PostList>
        </Suspense>
      </LayoutWithSideMenu>
    </div>
  );
};

const PostList = ({ resource }) => {
  const postList = resource.read();

  console.log(postList);
  return (
    <div>
      {postList &&
        postList.map((post, index) => (
          <div key={index}>
            <PostItem post={post}></PostItem>
          </div>
        ))}
    </div>
  );
};

const PostItem = ({ post }) => {
  return (
    <div>
      <div>제목 : {post.title}</div>
      <div>내용 : {post.description}</div>
    </div>
  );
};

export default MyBoardPage;
