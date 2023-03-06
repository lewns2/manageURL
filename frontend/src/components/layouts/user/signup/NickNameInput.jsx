import { InputLabel } from '../../../parts';
import StyleInput from '../../../parts/input/StyleInput';
import { styleUtils } from '../../../../styles';

const Label = () => {
  return (
    <div className={`${styleUtils.w80}`}>
      <InputLabel>닉네임</InputLabel>
    </div>
  );
};

const Input = ({ children, ...rest }) => {
  return <StyleInput {...rest}>{children}</StyleInput>;
};

const NickName = {
  Label,
  Input,
};

export default NickName;
