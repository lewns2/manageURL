import { useNavigate } from 'react-router';

/* Componets */
import LoginBaseForm from './login-form/LoginBaseForm';

/* CSS 모듈 */
import {
  LayoutWithHeader,
  UserContainer,
  UserTitle,
  UserFormContent,
  LoginMenu,
  UserButtonContent,
} from '../../../components/layouts';

import { useLoginContext } from './hooks';
import { userApi } from '../user-api';

const Login = () => {
  const navigate = useNavigate();
  const userState = useLoginContext();
  return (
    <LayoutWithHeader>
      <UserContainer>
        <UserTitle>로그인</UserTitle>

        <UserFormContent>
          <LoginBaseForm />
        </UserFormContent>

        <UserButtonContent>
          <LoginMenu onClick={() => summitFormData(userState)}>로그인</LoginMenu>
          <LoginMenu onClick={() => navigate('/signup')}>회원가입하러가기</LoginMenu>
        </UserButtonContent>
      </UserContainer>
    </LayoutWithHeader>
  );
};

// role : Form Data로 로그인 API 요청을 한다.
const summitFormData = async (userState) => {
  const userInfo = await userApi.login(userState);
  resistLocalStorage(userInfo);
};

// // role : 로컬스토리지에 저장한다.
const resistLocalStorage = (userInfo) => {
  localStorage.setItem('nickName', userInfo.nickName);
};

export default Login;
