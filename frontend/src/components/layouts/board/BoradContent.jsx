import { styleUtils } from '../../../styles';
import { ContentStyle } from './Board.styles';

const BoardContent = ({ children }) => {
  return <ContentStyle className={`${styleUtils.flexCenter}`}>{children}</ContentStyle>;
};

export default BoardContent;
