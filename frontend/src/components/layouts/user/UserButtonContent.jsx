import { ButtonContentStyle } from './User.styles';
import { styleUtils } from '../../../styles';

const UserButtonContent = ({ children }) => {
  return <ButtonContentStyle className={`${styleUtils.flexCenter}`}>{children}</ButtonContentStyle>;
};

export default UserButtonContent;
