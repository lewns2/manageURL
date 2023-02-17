import { useEffect, useState } from 'react';
import { useBoardCreateContext } from '../../hooks';

// role : 글의 본문을 작성한다.
const CreateDescription = () => {
  const boardState = useBoardCreateContext();

  const [description, setDescription] = useState(boardState.description);

  useEffect(() => {
    boardState.description = description;
  });

  return (
    <div>
      <label>글</label>
      <textarea onChange={(e) => onChangeDescription(e, setDescription)}></textarea>
    </div>
  );
};

// role : 본문을 작성한다.
const onChangeDescription = (e, setTitle) => {
  setTitle(e.target.value);
};

export default CreateDescription;
