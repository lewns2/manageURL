import { useSignUpContext } from './hooks';

import { UserEmail, UserNickName, UserPassword } from './parts';
import { userApi } from '../../user-api';

// role : 회원 가입 폼(각각의 입력값을 취합)을 보여준다.
const UserSignUpBaseForm = () => {
  const userState = useSignUpContext();

  return (
    <>
      <form>
        <UserNickName />
        <UserEmail />
        <UserPassword />
      </form>
      <button onClick={() => summitFormData(userState)}>회원 가입</button>
    </>
  );
};

// role: 입력 데이터 값들의 유효성을 검증한다.

// role: Form Data로 회원 가입 API 요청을 한다.
const summitFormData = async (userState) => {
  const userId = await userApi.signUp(userState);
  console.log(userId);
};

export default UserSignUpBaseForm;
