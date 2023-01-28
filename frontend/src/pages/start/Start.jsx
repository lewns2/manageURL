import { useNavigate } from 'react-router';

export default function Start() {
  const navigate = useNavigate();

  return (
    <>
      <h2>시작하기</h2>

      <button onClick={() => navigate('/login')}>Start</button>
      <button onClick={() => navigate('/signup')}>회원가입</button>
    </>
  );
}
