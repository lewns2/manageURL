import { useState } from 'react';
import { UrlList } from './create-url';

// role : 동적인 URL 갯수 결정
const CreateUrlList = () => {
  const [size, setSize] = useState(1);

  return (
    <div>
      <HandleUrlSize setSize={setSize} />
      <UrlList size={size} />
    </div>
  );
};

// URL 데이터들의 갯수 조절
const HandleUrlSize = (props) => {
  return (
    <>
      <span onClick={() => props.setSize((prev) => prev + 1)}>+ 추가</span>
      <span onClick={() => props.setSize((prev) => (prev < 1 ? prev : prev - 1))}>- 삭제</span>
    </>
  );
};

export default CreateUrlList;
