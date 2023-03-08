import { useEffect, useState } from 'react';
import { Description } from '../../../../../../components/layouts/board';
import { useBoardCreateContext } from '../../hooks';

// role : 글의 본문을 작성한다.
const CreateDescription = () => {
  const boardState = useBoardCreateContext();

  const [description, setDescription] = useState(boardState.description);

  useEffect(() => {
    boardState.description = description;
  });

  return (
    <>
      <Description.TextArea onChange={(e) => onChangeDescription(e, setDescription)} />
    </>
  );
};

// role : 본문을 작성한다.
const onChangeDescription = (e, setTitle) => {
  setTitle(e.target.value);
};

export default CreateDescription;
