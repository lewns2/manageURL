import { BoardContainer, BoardTitle } from '../../../components/layouts/board';
import BoardContent from '../../../components/layouts/board/BoradContent';
import { LayoutWithSideMenu } from '../../../components/layouts/common';
import { BoardCreateBaseForm } from './create-form';

const BoardCreatePage = () => {
  return (
    <div>
      <LayoutWithSideMenu>
        <BoardContainer>
          <BoardTitle>글 작성</BoardTitle>

          <BoardContent>
            <BoardCreateBaseForm />
          </BoardContent>
        </BoardContainer>
      </LayoutWithSideMenu>
    </div>
  );
};

export default BoardCreatePage;
