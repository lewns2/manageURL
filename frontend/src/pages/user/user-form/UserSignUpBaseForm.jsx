import { UserEmail, UserPassword } from './parts';

const UserSignUpBaseForm = () => {
  return (
    <>
      <form>
        <UserEmail />
        <UserEmail />
        <UserPassword />
        <UserPassword />
        <button>회원가입</button>
      </form>
    </>
  );
};

export default UserSignUpBaseForm;
