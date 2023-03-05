import { useEffect, useState } from 'react';
import StyleInput from '../../../../../../components/parts/input/StyleInput';
import { useLoginContext } from '../../hooks';

// role : 패스워드를 완성한다.
const UserPassword = () => {
  const userState = useLoginContext();

  const [pwd, setPwd] = useState();

  useEffect(() => {
    userState.password = pwd;
  });

  return (
    <div>
      <label>비밀번호</label>
      <StyleInput type="password" onChange={(e) => onChangePassword(e, setPwd)}></StyleInput>
    </div>
  );
};

// role : 패스워드를 변경한다.
const onChangePassword = (e, setPwd) => {
  setPwd(e.target.value);
};

export default UserPassword;
