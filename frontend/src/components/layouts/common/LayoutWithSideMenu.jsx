import { styleUtils } from '../../../styles';
import SideMenu from '../sideMenu/SideMenu';
import { ContentSection } from './LayoutWithSideMenu.styles';

const LayoutWithSideMenu = ({ children }) => {
  return (
    <div className={`${styleUtils.flex}`}>
      <SideMenu />
      <ContentSection>{children}</ContentSection>
    </div>
  );
};

export default LayoutWithSideMenu;
