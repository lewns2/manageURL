import { styleUtils } from '../../../../styles';
import { WrapperStyle } from '../User.styles';

const InputWrapper = ({ children }) => {
  return <WrapperStyle className={`${styleUtils.flex}`}>{children}</WrapperStyle>;
};

export default InputWrapper;
