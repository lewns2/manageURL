import { Title } from '../../parts';
import { styleUtils } from '../../../styles';

const BoardTitle = ({ children }) => {
  return <Title className={`${styleUtils.flexCenter}`}>{children}</Title>;
};

export default BoardTitle;
