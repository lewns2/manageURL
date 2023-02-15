import { useEffect, useState } from 'react';
import { useSignUpContext } from '../../hooks';

// role : NickName을 완성한다.
const UserNickName = () => {
  const userState = useSignUpContext();

  const [nickName, setNickName] = useState();

  useEffect(() => {
    userState.nickName = nickName;
  });

  return (
    <div>
      <label>닉네임</label>
      <input onChange={(e) => onChangeNickName(e, setNickName)}></input>
    </div>
  );
};

// role : NickName을 변경한다.
const onChangeNickName = (e, setNickName) => {
  setNickName(e.target.value);
};

export default UserNickName;
