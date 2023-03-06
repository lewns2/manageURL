import { InputLabel } from '../../../parts';
import StyleInput from '../../../parts/input/StyleInput';
import { styleUtils } from '../../../../styles';

const Label = () => {
  return (
    <div className={`${styleUtils.w80}`}>
      <InputLabel>비밀번호</InputLabel>
    </div>
  );
};

const Input = ({ children, ...rest }) => {
  return <StyleInput {...rest}>{children}</StyleInput>;
};

const Password = {
  Label,
  Input,
};

export default Password;
