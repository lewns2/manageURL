import { styleUtils } from '../../../../styles';
import { WrapperStyle } from '../User.styles';

const LoginInputWrapper = ({ children }) => {
  return <WrapperStyle className={`${styleUtils.flex}`}>{children}</WrapperStyle>;
};

export default LoginInputWrapper;
