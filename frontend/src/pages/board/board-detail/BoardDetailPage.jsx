import { Suspense } from 'react';
import boardApi from '../board-api/board';
import { useLocation } from 'react-router-dom';
import { PostDetail } from './parts';

const BoardDetailPage = () => {
  const location = useLocation();

  return (
    <div>
      <Suspense fallback={<p>...</p>}>
        <PostDetail
          resource={boardApi.fetchPost(
            localStorage.getItem('nickName'),
            location.state.id,
          )}></PostDetail>
      </Suspense>
    </div>
  );
};

export default BoardDetailPage;
