import { Fragment, useRef } from 'react';

// role : 단일 입력 작성, 변경, 삭제
const UrlItem = (props) => {
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
      <span onClick={() => deleteData()}>삭제</span>
    </Fragment>
  );
};

export default UrlItem;
