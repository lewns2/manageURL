import { useNavigate } from 'react-router';

/* Componets */
import LoginBaseForm from './login-form/LoginBaseForm';

/* CSS 모듈 */
import {
  LayoutWithHeader,
  UserContainer,
  UserFormContent,
  UserTitle,
  LoginMenu,
  UserButtonContent,
} from '../../../components/layouts';

import { useLoginContext } from './hooks';
import { userApi } from '../user-api';

const Login = () => {
  const navigate = useNavigate();
  const userState = useLoginContext();

  // role : Form Data로 로그인 API 요청을 한다.
  const summitFormData = async (userState) => {
    const res = await userApi.login(userState);
    resultHandler(res);
  };

  // role : 응답 결과에 따른 행동
  const resultHandler = (res) => {
    return res.hasOwnProperty('errorCode')
      ? alert(`${res.message}`)
      : (alert('성공적으로 로그인이 되었습니다.'), resistLocalStorage(res.nickName));
  };

  // role : 로컬스토리지에 저장한다.
  const resistLocalStorage = (userNickName) => {
    localStorage.setItem('nickName', userNickName);
    pageHandler();
  };

  // role : 게시판 페이지로 이동한다.
  const pageHandler = () => {
    navigate('/board');
  };

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

export default Login;
