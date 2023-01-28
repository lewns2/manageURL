import { useNavigate } from 'react-router';

import UserLoginBaseForm from './user-form/UserLoginBaseForm';

const Login = () => {
  const navigate = useNavigate();
  return (
    <div>
      <h2>로그인 창</h2>
      <UserLoginBaseForm />
      <button onClick={() => navigate('/signup')}>회원가입하러가기</button>
    </div>
  );
};

export default Login;
