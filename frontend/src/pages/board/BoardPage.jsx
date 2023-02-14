import { BoardMain } from './board-main';
import { BoardSidebar } from './board-sidebar';

const BoardPage = () => {
  return (
    <div>
      <h1>사용자 게시판</h1>
      <BoardSidebar />
      <BoardMain />
    </div>
  );
};

export default BoardPage;
