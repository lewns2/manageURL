import { useEffect, useState } from 'react';
import { Email } from '../../../../../../components/layouts/user/login';
import { useLoginContext } from '../../../hooks';
import SelectBox from './SelectBox';

// role : Email을 완성한다. (local + @ + domain)
const UserEmail = () => {
  const userState = useLoginContext();

  const [local, setLocal] = useState('');
  const [domain, setDomain] = useState('');

  useEffect(() => {
    userState.email = [local, domain].join('@');
  }, [userState, local, domain]);

  // role : 이메일의 앞 부분(local)을 변경한다.
  const onChangeLocal = (e, setLocal) => {
    setLocal(e.target.value);
  };

  // role : 이메일의 뒷 부분(domain)을 변경한다.
  const onChangeDomain = (e, setDomain) => {
    setDomain(e.target.value);
  };

  return (
    <>
      <Email.Label />
      <Email.LocalInput onChange={(e) => onChangeLocal(e, setLocal)} />
      <Email.At />
      <Email.DomainInput value={domain} onChange={(e) => onChangeDomain(e, setDomain)} />
      <SelectBox setDomain={setDomain}></SelectBox>
    </>
  );
};

export default UserEmail;
