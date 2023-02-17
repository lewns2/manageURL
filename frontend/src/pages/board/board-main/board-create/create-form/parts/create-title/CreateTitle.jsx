import { useEffect, useState } from 'react';
import { useBoardCreateContext } from '../../hooks';

// role : 글 제목을 작성한다.
const CreateTitle = () => {
  const boardState = useBoardCreateContext();

  const [title, setTitle] = useState(boardState.title);

  useEffect(() => {
    boardState.title = title;
  });

  return (
    <div>
      <label>제목</label>
      <input onChange={(e) => onChangeTitle(e, setTitle)}></input>
    </div>
  );
};

// role : 글 제목을 변경한다.
const onChangeTitle = (e, setTitle) => {
  setTitle(e.target.value);
};

export default CreateTitle;
