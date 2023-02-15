import { UserEmail, UserPassword } from './parts';

import { useLoginContext } from './hooks';

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
const summitFormData = (userState) => {
  console.log(userState);
};

export default UserLoginBaseForm;
