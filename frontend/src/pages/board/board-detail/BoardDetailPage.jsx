import { Suspense } from 'react';
import boardApi from '../board-api/board';
import { useLocation } from 'react-router-dom';
import { PostDetail } from './parts';
import { LayoutWithSideMenu } from '../../../components/layouts/common';
import { BoardContainer, BoardDetailWrapper, BoardTitle } from '../../../components/layouts/board';

const BoardDetailPage = () => {
  const location = useLocation();

  return (
    <LayoutWithSideMenu>
      <BoardContainer>
        <BoardTitle>상세 페이지</BoardTitle>

        <BoardDetailWrapper>
          <Suspense fallback={<p>...</p>}>
            <PostDetail
              resource={boardApi.fetchPost(
                localStorage.getItem('nickName'),
                location.state.id,
              )}></PostDetail>
          </Suspense>
        </BoardDetailWrapper>
      </BoardContainer>
    </LayoutWithSideMenu>
  );
};

export default BoardDetailPage;
