import { Link } from 'react-router-dom';
import { MenuWrapper, SideSection, Menu } from './SideMenu.styles';
import { Content, SubTitle, Title } from '../../parts/font';
import { useEffect, useState } from 'react';

const PATH = {
  START: { NAME: 'APP', URL: '/' },
  MYBOARD: { NAME: '내 글 목록', URL: '/myBoard' },
  WRITE: { NAME: '기록하기', URL: '/board/write' },
  MYURLS: { NAME: 'URL 모아보기', URL: '/myUrl' },
};

const SideMenu = () => {
  const [watchedHistory, setWatchedHistory] = useState();

  useEffect(() => {
    setWatchedHistory(JSON.parse(localStorage.getItem('watched')));
  }, []);

  return (
    <SideSection>
      <MenuWrapper>
        <MainMenu title={'APP 이름'}></MainMenu>

        <MainMenu title={'최근 방문'}></MainMenu>
        {watchedHistory &&
          watchedHistory.map((pathName, index) => (
            <SubMenu key={index} pathName={pathName}></SubMenu>
          ))}

        <MainMenu title={'글 관리'}></MainMenu>
        <SubMenu pathName="MYBOARD"></SubMenu>
        <SubMenu pathName="WRITE"></SubMenu>
        <SubMenu pathName="MYURLS"></SubMenu>

        <MainMenu title={`${localStorage.getItem('nickName')} 님`}></MainMenu>
      </MenuWrapper>
    </SideSection>
  );
};

const MainMenu = ({ title }) => {
  return (
    <Menu>
      <SubTitle>{title}</SubTitle>
    </Menu>
  );
};

const SubMenu = ({ pathName }) => {
  return (
    <Menu>
      <Link to={PATH[pathName].URL}>
        <Content onClick={() => handleHistory(pathName)}>{PATH[pathName].NAME}</Content>
      </Link>
    </Menu>
  );
};

// role : 로컬스토리지를 통한 3개까지의 최근 방문 관리
const handleHistory = (pathName) => {
  let watchedArr = [];
  let history = JSON.parse(localStorage.getItem('watched'));
  if (history !== null) {
    watchedArr.push(pathName, ...history);
  } else {
    watchedArr.push(pathName);
  }
  const tmp = new Set(watchedArr);
  const uniqueArr = [...tmp];
  if (uniqueArr.length > 3) {
    uniqueArr.shift();
  }
  localStorage.setItem('watched', JSON.stringify(uniqueArr));
};

export default SideMenu;
