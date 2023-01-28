// import UserEmail from './parts/user-email/UserEmail';
// import UserPassword from './parts/user-password/UserPassword';

import { UserEmail, UserPassword } from './parts';

const UserLoginBaseForm = () => {
  return (
    <>
      <form>
        <UserEmail />
        <UserPassword />
        <button>로그인</button>
      </form>
    </>
  );
};

export default UserLoginBaseForm;
