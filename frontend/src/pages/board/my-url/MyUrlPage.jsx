import { Suspense } from 'react';
import { boardApi } from '../board-api';
import { LayoutWithSideMenu } from '../../../components/layouts/common';
import { UrlList } from './parts';
import { BoardContainer, BoardTitle, BoardUrlWrapper } from '../../../components/layouts/board';

const MyUrlPage = () => {
  return (
    <div>
      <LayoutWithSideMenu>
        <BoardContainer>
          <BoardTitle>URL 모아보기</BoardTitle>

          <BoardUrlWrapper>
            <Suspense fallback={<p>URL 불러오는 중...</p>}>
              <UrlList resource={boardApi.fetchUrls(localStorage.getItem('nickName'))}></UrlList>
            </Suspense>
          </BoardUrlWrapper>
        </BoardContainer>
      </LayoutWithSideMenu>
    </div>
  );
};

export default MyUrlPage;
