import { InputWrapper } from '../../../../components/layouts';
import { UserEmail, UserPassword } from './parts';

const LoginBaseForm = () => {
  return (
    <form>
      <InputWrapper>
        <UserEmail />
      </InputWrapper>
      <InputWrapper>
        <UserPassword />
      </InputWrapper>
    </form>
  );
};
export default LoginBaseForm;
