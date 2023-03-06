import { useNavigate } from 'react-router';
import {
  LayoutWithHeader,
  HomeTitle,
  HomeContainer,
  HomeContent,
  HomeContentMenu,
} from '../../components/layouts';

export default function Home() {
  const navigate = useNavigate();

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
