import { Title } from '../../parts';
import { styleUtils } from '../../../styles';

const HomeTitle = ({ children }) => {
  return <Title className={`${styleUtils.flexCenter}`}>{children}</Title>;
};

export default HomeTitle;
