import { Title } from '../../parts';
import { styleUtils } from '../../../styles';

const UserTitle = ({ children }) => {
  return <Title className={`${styleUtils.flexCenter}`}>{children}</Title>;
};

export default UserTitle;
