const UserInfo = () => {
  return <div>{localStorage.getItem('nickName')} 님</div>;
};

export default UserInfo;
