const isLogin = () => {
  const flag = 'notLogin';
  const res = localStorage.getItem('nickName') ?? flag;
  return res !== flag ? true : false;
};

export default isLogin;
