import { ContentStyle } from './User.styles';
import { styleUtils } from '../../../styles';

const UserFormContent = ({ children }) => {
  return (
    <ContentStyle className={`${styleUtils.flexRowCenter} ${styleUtils.h280}`}>
      {children}
    </ContentStyle>
  );
};

export default UserFormContent;
