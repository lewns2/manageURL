import { useEffect } from 'react';
import { useNavigate } from 'react-router';
import {
  LayoutWithHeader,
  HomeTitle,
  HomeContainer,
  HomeContent,
  HomeContentMenu,
} from '../../components/layouts';

import { isLogin } from '../../util';

export default function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const res = isLogin();
    if (res) {
      navigate('/board');
    }
  }, []);

  return (
    <LayoutWithHeader>
      <HomeContainer>
        <HomeTitle>WELCOME!</HomeTitle>

        <HomeContent>
          <HomeContentMenu onClick={() => navigate('/login')}>시작하기</HomeContentMenu>
          <HomeContentMenu onClick={() => navigate('/signup')}>회원가입</HomeContentMenu>
        </HomeContent>
      </HomeContainer>
    </LayoutWithHeader>
  );
}
