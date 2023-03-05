import board from '../../../board-api/board';
import { useBoardCreateContext } from './hooks';
import { CreateDescription, CreateTitle, CreateUrlList } from './parts';

// role : 글 작성 Form 구성 및 FormData 제출
const BoardCreateBaseForm = () => {
  const boardState = useBoardCreateContext();

  return (
    <div>
      <form>
        <CreateTitle />
        <CreateDescription />
        <CreateUrlList />
      </form>
      <button>취소</button>
      <button onClick={() => summitBoardData(boardState)}>작성</button>
    </div>
  );
};

const summitBoardData = async (boardState) => {
  console.log(boardState);
  const res = await board.createPost(localStorage.getItem('nickName'), boardState);
  console.log(res);
};

export default BoardCreateBaseForm;
