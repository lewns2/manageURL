import { UserEmail, UserPassword } from './parts';

import { useLoginContext } from './hooks';
import { userApi } from '../../user-api';

const UserLoginBaseForm = () => {
  const userState = useLoginContext();

  return (
    <>
      <form>
        <UserEmail />
        <UserPassword />
      </form>
      <button onClick={() => summitFormData(userState)}>로그인</button>
    </>
  );
};

// role : Form Data로 로그인 API 요청을 한다.
const summitFormData = async (userState) => {
  const userInfo = await userApi.login(userState);
  resistLocalStorage(userInfo);
};

// // role : 로컬스토리지에 저장한다.
const resistLocalStorage = (userInfo) => {
  localStorage.setItem('nickName', userInfo.nickName);
};

export default UserLoginBaseForm;
