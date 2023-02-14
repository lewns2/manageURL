import { NavLink } from 'react-router-dom';

const Categroy = () => {
  return (
    <div>
      <MenuList></MenuList>
    </div>
  );
};

const MenuList = () => {
  const menus = [
    { name: '홈', path: '/board' },
    { name: '기록하기', path: '/board/write' },
    { name: '글 목록', path: '/myBoard' },
    { name: 'URL 모아보기', path: '/myUrl' },
  ];

  return (
    <div>
      {menus.map((menu) => (
        <NavLink to={menu.path}>
          <h3>{menu.name}</h3>
        </NavLink>
      ))}
    </div>
  );
};

export default Categroy;
