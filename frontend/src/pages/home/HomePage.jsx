import { useNavigate } from 'react-router';
import Header from '../../components/layouts/header/Header';
import CommonBtn from '../../components/parts/button/CommonBtn';
import { Content, Title } from '../../components/parts/font';

export default function Home() {
  const navigate = useNavigate();

  return (
    <>
      <Header />
      <Title>시작하기</Title>

      <CommonBtn onClick={() => navigate('/login')}>
        <Content>시작하기</Content>
      </CommonBtn>
      <CommonBtn onClick={() => navigate('/signup')}>
        <Content>회원가입</Content>
      </CommonBtn>
    </>
  );
}
