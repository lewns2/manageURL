import { useEffect, useState } from 'react';
import { Fragment, useRef } from 'react';

import { useBoardCreateContext } from '../../../hooks';

// role : 배열 생성 및 변경
const CreateUrl = (props) => {
  const url = {
    address: '',
    category: '',
  };

  const boardState = useBoardCreateContext();
  const [totalUrls, setTotalUrls] = useState([url]);

  // 상위 컴포넌트의 상태 변화에 따른 렌더링
  useEffect(() => {
    setTotalUrls(
      props.size > totalUrls.length ? [...totalUrls, url] : totalUrls.slice(0, props.size),
    );
  }, [props.size]);

  return (
    <div>
      {props.size >= 1 &&
        totalUrls.map((value, index) => (
          <div key={index}>
            <SingleUrlData
              index={index}
              setTotalUrls={setTotalUrls}
              totalUrls={totalUrls}
              value={value}
            />
          </div>
        ))}
      <span onClick={() => (boardState.urls = totalUrls)}>저장</span>
    </div>
  );
};

// 단일 입력 작성, 변경, 삭제
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
    props.setTotalUrls(() =>
      (function () {
        const newArr = Array.from(props.totalUrls);
        newArr[props.index] = url;
        return newArr;
      })(),
    );
  };

  const deleteData = () => {
    props.setTotalUrls(() =>
      (function () {
        const newArr = Array.from(props.totalUrls);
        const deletedValue = newArr.at(props.index);
        return newArr.filter((value) => value !== deletedValue);
      })(),
    );
  };

  return (
    <Fragment>
      <label>URL 주소 : </label>
      <input
        onChange={(e) => handleData(e)}
        name="address"
        ref={addressInputRef}
        value={props.value.address}></input>
      <label> 카테고리 : </label>
      <input
        onChange={(e) => handleData(e)}
        name="category"
        ref={categoryInputRef}
        value={props.value.category}></input>
      <span onClick={(e) => deleteData()}>삭제</span>
    </Fragment>
  );
};

export default CreateUrl;
