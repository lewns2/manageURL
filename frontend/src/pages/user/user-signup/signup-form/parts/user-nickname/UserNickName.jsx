import { useEffect, useState } from 'react';
import { NickName } from '../../../../../../components/layouts/user/signup';
import { useSignUpContext } from '../../../hooks';

// role : NickName을 완성한다.
const UserNickName = () => {
  const userState = useSignUpContext();

  const [nickName, setNickName] = useState();

  useEffect(() => {
    userState.nickName = nickName;
  });

  return (
    <>
      <NickName.Label />
      <NickName.Input onChange={(e) => onChangeNickName(e, setNickName)} />
    </>
  );
};

// role : NickName을 변경한다.
const onChangeNickName = (e, setNickName) => {
  setNickName(e.target.value);
};

export default UserNickName;
