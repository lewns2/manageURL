import { useNavigate } from 'react-router';

import {
  LayoutWithHeader,
  UserContainer,
  UserTitle,
  UserFormContent,
  LoginMenu,
  UserButtonContent,
} from '../../../components/layouts';

import { UserSignUpBaseForm } from './signup-form';
import { useSignUpContext } from './hooks';
import { userApi } from '../user-api';

const SignUp = () => {
  const navigate = useNavigate();
  const userState = useSignUpContext();

  // role: Form Data로 회원 가입 API 요청을 한다.
  const summitFormData = async (userState) => {
    const userId = await userApi.signUp(userState);
    pageHandler(userId);
  };

  // role: 회원 가입 처리 여부에 따라 이동할 페이지를 결정한다.
  const pageHandler = (userId) => {
    if (userId !== null) {
      alert('회원 가입이 성공적으로 처리되었습니다.');
      moveToLogin();
    }
  };

  // role: 로그인 페이지로 이동한다.
  const moveToLogin = () => {
    navigate('/login');
  };

  return (
    <LayoutWithHeader>
      <UserContainer>
        <UserTitle>회원 가입</UserTitle>

        <UserFormContent>
          <UserSignUpBaseForm />
        </UserFormContent>

        <UserButtonContent>
          <LoginMenu onClick={() => summitFormData(userState)}>회원 가입</LoginMenu>
          <LoginMenu onClick={() => navigate('/login')}>로그인하러가기</LoginMenu>
        </UserButtonContent>
      </UserContainer>
    </LayoutWithHeader>
  );
};

export default SignUp;
