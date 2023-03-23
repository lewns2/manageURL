import { NickNameValidation, UserEmail, UserNickName, UserPassword } from './parts';
import { InputWrapper } from '../../../../components/layouts';

// role : 회원 가입 폼(각각의 입력값을 취합)을 보여준다.
const UserSignUpBaseForm = () => {
  return (
    <form>
      <InputWrapper>
        <UserNickName />
        <NickNameValidation />
      </InputWrapper>

      <InputWrapper>
        <UserEmail />
      </InputWrapper>

      <InputWrapper>
        <UserPassword />
      </InputWrapper>
    </form>
  );
};

export default UserSignUpBaseForm;
