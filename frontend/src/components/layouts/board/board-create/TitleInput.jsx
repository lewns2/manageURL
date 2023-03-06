import { InputLabel } from '../../../parts';
import StyleInput from '../../../parts/input/StyleInput';
import { styleUtils } from '../../../../styles';

const Label = () => {
  return (
    <div className={`${styleUtils.w80}`}>
      <InputLabel>제목</InputLabel>
    </div>
  );
};

const Input = ({ children, ...rest }) => {
  return <StyleInput {...rest}>{children}</StyleInput>;
};

const Title = {
  Label,
  Input,
};

export default Title;
