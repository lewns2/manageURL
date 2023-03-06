import { useEffect, useState } from 'react';
import { Email } from '../../../../../../components/layouts';
import { useSignUpContext } from '../../../hooks';

// role : Email을 완성한다. (local + @ + domain)
const UserEmail = () => {
  const userState = useSignUpContext();

  const [local, setLocal] = useState('');
  const [domain, setDomain] = useState('');

  useEffect(() => {
    userState.email = [local, domain].join('@');
  }, [userState, local, domain]);

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

// role : 이메일 도메인을 선택한다.
const SelectBox = (props) => {
  const [selected, setSelected] = useState('');

  const options = [
    { value: '', label: '직접 입력' },
    { value: 'naver.com', label: 'naver.com' },
    { value: 'google.com', label: 'google.com' },
  ];

  const handleSelect = (e) => {
    setSelected(e.target.value);
    onChangeDomain(e, props.setDomain);
  };

  return (
    <>
      <Email.SelectBox onChange={handleSelect} value={selected}>
        {options.map((option) => (
          <option key={option.label} value={option.value}>
            {option.label}
          </option>
        ))}
      </Email.SelectBox>
    </>
  );
};

// role : 이메일의 앞 부분(local)을 변경한다.
const onChangeLocal = (e, setLocal) => {
  setLocal(e.target.value);
};

// role : 이메일의 뒷 부분(domain)을 변경한다.
const onChangeDomain = (e, setDomain) => {
  setDomain(e.target.value);
};

export default UserEmail;
