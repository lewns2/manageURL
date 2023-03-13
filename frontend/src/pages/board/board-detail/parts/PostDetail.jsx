const PostDetail = ({ resource }) => {
  const postInfo = resource.read();

  return (
    <div>
      <p>생성일 : {postInfo.createDate}</p>
      <p>수정일 : {postInfo.updateDate}</p>
      <p>제목 : {postInfo.title}</p>
      <p>내용 : {postInfo.description}</p>
      <div>
        URLS :
        {postInfo.urls.map((value, index) => (
          <div key={index}>
            <p>주소 : {value.address} </p>
            <p>카테고리 : {value.category}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default PostDetail;
