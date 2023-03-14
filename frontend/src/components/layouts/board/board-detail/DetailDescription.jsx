import { styleUtils } from '../../../../styles';
import { DetailDescriptionStyle } from './BoardDetail.styles';

const DetailDescription = ({ children }) => {
  return (
    <DetailDescriptionStyle className={`${styleUtils.h480}`}>{children}</DetailDescriptionStyle>
  );
};

export default DetailDescription;
