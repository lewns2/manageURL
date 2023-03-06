import { InputLabel, StyleSelect } from '../../../parts';
import StyleInput from '../../../parts/input/StyleInput';
import { styleUtils } from '../../../../styles';

const Label = () => {
  return (
    <div className={`${styleUtils.w80}`}>
      <InputLabel>이메일</InputLabel>
    </div>
  );
};

const At = () => {
  return <InputLabel>@</InputLabel>;
};

const LocalInput = ({ children, ...rest }) => {
  return <StyleInput {...rest}>{children}</StyleInput>;
};

const DomainInput = ({ children, ...rest }) => {
  return <StyleInput {...rest}>{children}</StyleInput>;
};

const SelectBox = ({ children, ...rest }) => {
  return <StyleSelect {...rest}>{children}</StyleSelect>;
};

const Email = {
  Label,
  At,
  LocalInput,
  DomainInput,
  SelectBox,
};

export default Email;
