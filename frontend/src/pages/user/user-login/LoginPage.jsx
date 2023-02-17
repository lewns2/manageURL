import { useNavigate } from 'react-router';

/* Componets */
import UserLoginBaseForm from './login-form/UserLoginBaseForm';

/* CSS 모듈 */
import { Title, SubTitle } from '../../../components/parts/font';
import { FormBtn } from '../../../components/parts';

const Login = () => {
  const navigate = useNavigate();
  return (
    <div>
      <Title>로그인 창</Title>
      <SubTitle>로그인 창</SubTitle>

      <UserLoginBaseForm />
      <FormBtn onClick={() => navigate('/signup')}>회원가입</FormBtn>
      <button onClick={() => navigate('/signup')}>회원가입하러가기</button>
    </div>
  );
};

export default Login;
