import { useState } from 'react';
import { UrlCreateMenu, UrlCreateMenuContainer } from '../../../../../../components/layouts/board';
import { UrlList } from './create-url';

// role : 동적인 URL 갯수 결정
const CreateUrlList = () => {
  const [size, setSize] = useState(1);

  return (
    <>
      <HandleUrlSize setSize={setSize} />
      <UrlList size={size} />
    </>
  );
};

// URL 데이터들의 갯수 조절
const HandleUrlSize = (props) => {
  return (
    <UrlCreateMenuContainer>
      <UrlCreateMenu.Create onClick={() => props.setSize((prev) => prev + 1)}>
        + 추가
      </UrlCreateMenu.Create>
      <UrlCreateMenu.Delete onClick={() => props.setSize((prev) => (prev < 1 ? prev : prev - 1))}>
        - 삭제
      </UrlCreateMenu.Delete>
    </UrlCreateMenuContainer>
  );
};

export default CreateUrlList;
