import { Fragment, useRef } from 'react';

import { useBoardCreateContext } from '../../../hooks';

const CreateUrl = (props) => {
  const boardState = useBoardCreateContext();

  return (
    <div>
      {props.size >= 1 &&
        Array(props.size)
          .fill(null)
          .map((value, index) => (
            <div key={index}>
              <SingleUrlData index={index} urlArr={boardState.urls} />
            </div>
          ))}
      <span onClick={() => console.log(boardState)}>저장</span>
    </div>
  );
};

// Component : 하나의 URL 인풋 데이터 관리 컴포넌트 => 문제점 : state 변경에 따른 input 한글자 후 focus 잃음. => 비제어 컴포넌트로 변경
const SingleUrlData = (props) => {
  const url = {
    address: '',
    category: '',
  };
  const addressInputRef = useRef();
  const categoryInputRef = useRef();

  const handleData = () => {
    url.address = addressInputRef.current.value;
    url.category = categoryInputRef.current.value;
    props.urlArr[props.index] = url;
  };

  return (
    <Fragment>
      <label>URL 주소 : </label>
      <input onChange={() => handleData()} name="address" ref={addressInputRef}></input>
      <label> 카테고리 : </label>
      <input onChange={() => handleData()} name="category" ref={categoryInputRef}></input>
      <button>삭제</button>
    </Fragment>
  );
};

export default CreateUrl;
