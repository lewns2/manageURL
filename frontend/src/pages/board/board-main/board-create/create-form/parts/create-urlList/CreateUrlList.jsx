import { useState } from 'react';
import { CreateUrl } from './create-url';

const CreateUrlList = () => {
  const [size, setSize] = useState(1);

  return (
    <div>
      <span onClick={() => setSize((prev) => prev + 1)}>+ 추가</span>
      <span onClick={() => setSize((prev) => (prev < 1 ? prev : prev - 1))}>- 삭제</span>
      {size}
      <CreateUrl size={size} />
    </div>
  );
};

export default CreateUrlList;
