import { useState } from 'react';
import { Email } from '../../../../../../components/layouts/user/login';

// role : 이메일 도메인을 선택한다.
const SelectBox = (props) => {
  const [selected, setSelected] = useState('');

  const options = [
    { value: '', label: '직접 입력' },
    { value: 'naver.com', label: 'naver.com' },
    { value: 'google.com', label: 'google.com' },
  ];

  // role : 도메인을 선택한다.
  const handleSelect = (e) => {
    setSelected(e.target.value);
    onChangeDomain(e, props.setDomain);
  };

  // role : 이메일의 뒷 부분(domain)을 변경한다.
  const onChangeDomain = (e, setDomain) => {
    setDomain(e.target.value);
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

export default SelectBox;
