import { useNavigate } from 'react-router';
import UserSignUpBaseForm from './signup-form/UserSignUpBaseForm';

import {
  LayoutWithHeader,
  UserContainer,
  UserTitle,
  UserFormContent,
  LoginMenu,
  UserButtonContent,
} from '../../../components/layouts';

import { useSignUpContext } from './hooks';
import { userApi } from '../user-api';

const SignUp = () => {
  const navigate = useNavigate();
  const userState = useSignUpContext();

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

// role: 입력 데이터 값들의 유효성을 검증한다.

// role: Form Data로 회원 가입 API 요청을 한다.
const summitFormData = async (userState) => {
  const userId = await userApi.signUp(userState);
  console.log(userId);
};

export default SignUp;
