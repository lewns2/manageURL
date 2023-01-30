import { useContext, useEffect, useState } from 'react';

import { UserContext } from '../../../user-context/UserContext';

// role : 패스워드를 완성한다.
const UserPassword = () => {
  const userState = useContext(UserContext);

  const [pwd, setPwd] = useState();

  useEffect(() => {
    userState.password = pwd;
    console.log(userState.password);
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
