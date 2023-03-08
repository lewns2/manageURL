import { Suspense } from 'react';
import { boardApi } from '../board-api';
import { LayoutWithSideMenu } from '../../../components/layouts/common';
import {
  BoardContainer,
  BoardTitle,
  BoardPostWrapper,
  BoardPostContentWrapper,
} from '../../../components/layouts/board';
import { PostList } from './parts';

const MyBoardPage = () => {
  return (
    <div>
      <LayoutWithSideMenu>
        <BoardContainer>
          <BoardTitle>아카이브</BoardTitle>

          <BoardPostWrapper>
            <Suspense fallback={<p>게시글 불러오는 중...</p>}>
              <BoardPostContentWrapper>
                <PostList
                  resource={boardApi.fetchPosts(localStorage.getItem('nickName'))}></PostList>
              </BoardPostContentWrapper>
            </Suspense>
          </BoardPostWrapper>
        </BoardContainer>
      </LayoutWithSideMenu>
    </div>
  );
};

export default MyBoardPage;
