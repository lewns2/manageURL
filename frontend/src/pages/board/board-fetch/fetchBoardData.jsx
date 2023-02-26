const baseUrl = 'http://localhost:8080/api/';

/* 사용자 게시글 목록 불러오기 */
function fetchPosts() {}

/* 글 작성하기 */
function fetchWrite() {}

/* URL 모아보기 */
function fetchUrls() {}

function fetchBoardData() {
  return {
    posts: fetchPosts(),
    urls: fetchUrls(),
    write: fetchWrite(),
  };
}

export default fetchBoardData;
