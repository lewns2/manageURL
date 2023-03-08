import { styleUtils } from '../../../../styles';
import { BoardPostWrapperStyle } from './MyBoard.styles';

const BoardPostWrapper = ({ children }) => {
  return <BoardPostWrapperStyle className={`${styleUtils.flex}`}>{children}</BoardPostWrapperStyle>;
};

export default BoardPostWrapper;
