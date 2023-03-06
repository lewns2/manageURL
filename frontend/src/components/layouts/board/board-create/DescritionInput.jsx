import { InputLabel, StyleTextArea } from '../../../parts';
import { styleUtils } from '../../../../styles';

const Label = () => {
  return (
    <div className={`${styleUtils.w80}`}>
      <InputLabel>내용</InputLabel>
    </div>
  );
};

const TextArea = ({ children, ...rest }) => {
  return <StyleTextArea {...rest}>{children}</StyleTextArea>;
};

const Description = {
  Label,
  TextArea,
};

export default Description;
