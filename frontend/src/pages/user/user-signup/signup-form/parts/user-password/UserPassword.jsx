import { useEffect, useState } from 'react';
import { useSignUpContext } from '../../hooks';

// role : 패스워드를 완성한다.
const UserPassword = () => {
  const userState = useSignUpContext();

  const [pwd, setPwd] = useState();

  useEffect(() => {
    userState.password = pwd;
  });

  return (
    <div>
      <label>
        비밀번호
        <input type="password" onChange={(e) => onChangePassword(e, setPwd)}></input>
      </label>
    </div>
  );
};

// role : 패스워드를 변경한다.
const onChangePassword = (e, setPwd) => {
  setPwd(e.target.value);
};

export default UserPassword;
