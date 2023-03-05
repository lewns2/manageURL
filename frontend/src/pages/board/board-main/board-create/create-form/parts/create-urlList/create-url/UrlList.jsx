import { useEffect, useState, useMemo } from 'react';
import { useBoardCreateContext } from '../../../hooks';
import UrlItem from './UrlItem';

// role : URL 전체 배열 다루기
const UrlList = (props) => {
  const url = useMemo(() => ({ address: '', category: '' }), []);
  const boardState = useBoardCreateContext();
  const [totalUrls, setTotalUrls] = useState([url]);

  // 상위 컴포넌트의 상태 변화에 따른 렌더링
  useEffect(() => {
    setTotalUrls((prev) => (props.size > prev.length ? [...prev, url] : prev.slice(0, props.size)));
  }, [props.size, url]);

  // 배열 상태 변화 감지
  useEffect(() => {
    boardState.urls = totalUrls;
  }, [totalUrls, boardState]);

  return (
    <div>
      {props.size >= 1 &&
        totalUrls.map((value, index) => (
          <div key={index}>
            <UrlItem
              index={index}
              setTotalUrls={setTotalUrls}
              totalUrls={totalUrls}
              value={value}
            />
          </div>
        ))}
    </div>
  );
};

export default UrlList;
