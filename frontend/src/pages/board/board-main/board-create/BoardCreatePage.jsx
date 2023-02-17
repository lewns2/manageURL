import { BoardSidebar } from '../../board-sidebar';
import { BoardCreateBaseForm } from './create-form';

const BoardCreatePage = () => {
  return (
    <div>
      <BoardSidebar />
      <h2>게시글 작성 컴포넌트</h2>
      <BoardCreateBaseForm />
    </div>
  );
};

export default BoardCreatePage;
