import { DetailInfoStyle } from './BoardDetail.styles';
import { styleUtils } from '../../../../styles';

const DetailInfo = ({ children }) => {
  return <DetailInfoStyle className={`${styleUtils.flex}`}>{children}</DetailInfoStyle>;
};

export default DetailInfo;
