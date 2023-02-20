import { useState } from 'react';
import { CreateUrl } from './create-url';

const CreateUrlList = () => {
  const [size, setSize] = useState(1);

  return (
    <div>
      <HandleUrlSize setSize={setSize} />
      <CreateUrl size={size} />
    </div>
  );
};

// Component : URL 데이터들의 갯수 조절
const HandleUrlSize = (props) => {
  return (
    <>
      <span onClick={() => props.setSize((prev) => prev + 1)}>+ 추가</span>
      <span onClick={() => props.setSize((prev) => (prev < 1 ? prev : prev - 1))}>- 삭제</span>
    </>
  );
};

export default CreateUrlList;
