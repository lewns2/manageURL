import { useEffect, useState } from 'react';
import { Password } from '../../../../../../components/layouts';
import { useLoginContext } from '../../../hooks';

// role : 패스워드를 완성한다.
const UserPassword = () => {
  const userState = useLoginContext();

  const [pwd, setPwd] = useState();

  useEffect(() => {
    userState.password = pwd;
  });

  return (
    <>
      <Password.Label />
      <Password.Input
        type="password"
        onChange={(e) => onChangePassword(e, setPwd)}></Password.Input>
    </>
  );
};

// role : 패스워드를 변경한다.
const onChangePassword = (e, setPwd) => {
  setPwd(e.target.value);
};

export default UserPassword;
