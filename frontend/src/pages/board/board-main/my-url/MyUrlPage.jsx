import { Suspense } from 'react';
import { BoardSidebar } from '../../board-sidebar';
import { boardApi } from '../../board-api';

const MyUrlPage = () => {
  return (
    <div>
      <BoardSidebar />
      <h2>URL 모아보기 컴포넌트</h2>
      <Suspense fallback={<p>URL 불러오는 중...</p>}>
        <UrlList resource={boardApi.fetchUrls(localStorage.getItem('nickName'))}></UrlList>
      </Suspense>
    </div>
  );
};

const UrlList = ({ resource }) => {
  const urlList = resource.read();
  console.log(urlList);

  return (
    <div>
      {urlList &&
        urlList.map((url, index) => (
          <div key={index}>
            <UrlItem url={url}></UrlItem>
          </div>
        ))}
    </div>
  );
};

const UrlItem = ({ url }) => {
  return (
    <div>
      <div>카테고리 : {url.category}</div>
      <div>주소 : {url.address}</div>
    </div>
  );
};

export default MyUrlPage;
