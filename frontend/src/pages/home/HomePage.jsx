import { useNavigate } from 'react-router';
import Header from '../../components/layouts/Header';

export default function Home() {
  const navigate = useNavigate();

  return (
    <>
      <Header />
      <h2>시작하기</h2>

      <button onClick={() => navigate('/login')}>Start</button>
      <button onClick={() => navigate('/signup')}>회원가입</button>
    </>
  );
}
