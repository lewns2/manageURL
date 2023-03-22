import { LayoutWithSideMenu } from '../../../components/layouts/common';

const BoardHomePage = () => {
  return (
    <div>
      <LayoutWithSideMenu>
        <h2>히스토리</h2>
        {/* TODO : 간단한 메모 작성하기*/}
        <div>
          {/* <textarea value="글을 작성하세요..."></textarea> */}
          <div>
            <p>태그</p>
            <p>확대</p>
          </div>
          <div>작성</div>
        </div>
        {/* TODO : 날짜별 필터 */}
        <div>날짜별 게시글</div>

        {/* TODO : 작성된 URL 태그 모아보기 */}
        <div>작성된 태그</div>

        {/* TODO : 검색창 */}
        {/* <input value="search..."></input> */}
      </LayoutWithSideMenu>
    </div>
  );
};

export default BoardHomePage;
