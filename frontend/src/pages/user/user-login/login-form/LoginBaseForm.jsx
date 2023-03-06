import { LoginInputWrapper } from '../../../../components/layouts';
import { UserEmail, UserPassword } from './parts';

const LoginBaseForm = () => {
  return (
    <form>
      <LoginInputWrapper>
        <UserEmail />
      </LoginInputWrapper>
      <LoginInputWrapper>
        <UserPassword />
      </LoginInputWrapper>
    </form>
  );
};
export default LoginBaseForm;
