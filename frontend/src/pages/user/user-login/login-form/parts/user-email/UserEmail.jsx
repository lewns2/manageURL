import { useEffect, useState } from 'react';
import StyleInput from '../../../../../../components/parts/input/StyleInput';
import { useLoginContext } from '../../hooks';

// role : Email을 완성한다. (local + @ + domain)
const UserEmail = () => {
  const userState = useLoginContext();

  const [local, setLocal] = useState('');
  const [domain, setDomain] = useState('');

  useEffect(() => {
    userState.email = [local, domain].join('@');
  }, [userState, local, domain]);

  return (
    <div>
      <label>
        이메일
        <StyleInput onChange={(e) => onChangeLocal(e, setLocal)}></StyleInput>
      </label>
      <span>@</span>

      <StyleInput value={domain} onChange={(e) => onChangeDomain(e, setDomain)}></StyleInput>

      <SelectBox setDomain={setDomain}></SelectBox>
    </div>
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
      <select onChange={handleSelect} value={selected}>
        {options.map((option) => (
          <option key={option.label} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>
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
