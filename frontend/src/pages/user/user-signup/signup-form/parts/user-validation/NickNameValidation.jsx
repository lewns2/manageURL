import userApi from '../../../../user-api/user';
import { useSignUpContext } from '../../../hooks';

const NickNameValidation = () => {
  const userState = useSignUpContext();

  const getNickName = () => {
    const nickName = userState.nickName;
    checkNickName(nickName);
  };

  const checkNickName = async (nickName) => {
    const res = await userApi.checkNickName(nickName);
    showResult(res);
  };

  const showResult = (res) => {
    if (res) {
      userState.check.nickName = true;
    }
    alert(res ? '사용 가능한 닉네임입니다.' : '중복된 닉네임이 존재합니다.');
  };

  return (
    <>
      <div onClick={() => getNickName()}>중복 확인</div>
    </>
  );
};

export default NickNameValidation;
