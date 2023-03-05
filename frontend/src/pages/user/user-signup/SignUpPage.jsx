import { useNavigate } from 'react-router';
import Header from '../../../components/layouts/header/Header';

import UserSignUpBaseForm from './signup-form/UserSignUpBaseForm';

const SignUp = () => {
  const navigate = useNavigate();

  return (
    <div>
      <Header />
      <h2>회원가입 창</h2>
      <UserSignUpBaseForm />
      <button onClick={() => navigate('/login')}>로그인하러가기</button>
    </div>
  );
};

export default SignUp;
