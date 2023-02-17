import { CreateDescription, CreateTitle, CreateUrlList } from './parts';

const BoardCreateBaseForm = () => {
  return (
    <div>
      <form>
        <CreateTitle />
        <CreateDescription />
        <CreateUrlList />
      </form>
      <button>취소</button>
      <button>작성</button>
    </div>
  );
};

export default BoardCreateBaseForm;
