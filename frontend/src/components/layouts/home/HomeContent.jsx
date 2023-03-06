import { ContentStyle } from './Home.styles';
import { styleUtils } from '../../../styles';

const HomeContent = ({ children }) => {
  return <ContentStyle className={`${styleUtils.flexCenter}`}>{children}</ContentStyle>;
};

export default HomeContent;
