import { Link } from 'react-router-dom';
import { MenuWrapper, SideSection, Menu } from './SideMenu.styles';
import { Content, SubTitle, Title } from '../../parts/font';

const SideMenu = () => {
  return (
    <SideSection>
      <MenuWrapper>
        <Menu>
          <Link to="/">
            <Title>APP</Title>
          </Link>
        </Menu>

        <Menu>
          <SubTitle>최근 방문</SubTitle>
        </Menu>

        <Menu>
          <Content>-</Content>
        </Menu>

        <Menu>
          <Content>-</Content>
        </Menu>

        <Menu>
          <Content>-</Content>
        </Menu>

        <Menu>
          <SubTitle>글 관리</SubTitle>
        </Menu>

        <Menu>
          <Link to="/myBoard">
            <Content>글 목록</Content>
          </Link>
        </Menu>

        <Menu>
          <Link to="/board/write">
            <Content>기록하기</Content>
          </Link>
        </Menu>

        <Menu>
          <SubTitle>즐겨 찾기</SubTitle>
        </Menu>

        <Menu>
          <Link to="/myUrl">
            <Content>URL 모아보기</Content>
          </Link>
        </Menu>

        <Menu>
          <div>{localStorage.getItem('nickName')} 님</div>
        </Menu>
      </MenuWrapper>
    </SideSection>
  );
};

export default SideMenu;
