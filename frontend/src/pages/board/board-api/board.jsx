import { METHOD, HEADERS, ENDPOINTS } from '../../../constants/api';

const boardApi = {
  /* 글 작성하기 */
  createPost: async (nickName, data) => {
    data.nickName = nickName;

    const res = await fetch(ENDPOINTS.POST, {
      method: METHOD.POST,
      headers: HEADERS.JSON,
      body: JSON.stringify(data),
    });

    const resData = await res.json();

    return resData;
  },

  /* 사용자 게시글 목록 불러오기 */
  fetchPosts: (nickName) => {
    let resData = null;
    const suspender = fetch(ENDPOINTS.MY_POSTS(nickName), {
      method: METHOD.GET,
    })
      .then((response) => response.json())
      .then((data) => {
        setTimeout(() => {
          resData = data;
        }, 2000);
      });

    return {
      read() {
        if (resData === null) {
          throw suspender;
        } else {
          return resData.boards;
        }
      },
    };
  },

  /* 단일 게시글 조회 */
  fetchPost: (nickName, boardId) => {
    let resData = null;
    const suspender = fetch(ENDPOINTS.MY_POST_BY_ID(nickName, boardId), {
      method: METHOD.GET,
    })
      .then((res) => res.json())
      .then((data) => {
        resData = data;
      });

    return {
      read() {
        if (resData === null) {
          throw suspender;
        } else {
          return resData;
        }
      },
    };
  },

  /* URL 모아보기 */
  fetchUrls: (nickName) => {
    let resData = null;

    const suspender = fetch(ENDPOINTS.MY_URLS(nickName), {
      method: METHOD.GET,
    })
      .then((response) => response.json())
      .then((data) => {
        setTimeout(() => {
          resData = data;
        }, 2000);
      });

    return {
      read() {
        if (resData === null) {
          throw suspender;
        } else {
          return resData.urls;
        }
      },
    };
  },
};

export default boardApi;
