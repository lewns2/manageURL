import { useEffect, useState } from 'react';

import { useBoardCreateContext } from '../../../hooks';

const CreateUrl = (props) => {
  const boardState = useBoardCreateContext();

  const [url, setUrl] = useState({
    address: '',
    category: '',
  });

  return (
    <div>
      {props.size >= 1 &&
        Array(props.size)
          .fill(null)
          .map((value, index) => (
            <div key={index}>
              <label>URL 주소 : </label>
              <input></input>
              <label> 카테고리 : </label>
              <input></input>
              <button>삭제</button>
              <span>인덱스 : {index}</span>
            </div>
          ))}
    </div>
  );
};

export default CreateUrl;
