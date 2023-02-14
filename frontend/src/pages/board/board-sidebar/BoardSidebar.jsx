import { Category, UserInfo } from './parts';

const BoardSidebar = () => {
  return (
    <div>
      <h2>사이드바</h2>
      <UserInfo />
      <Category />
    </div>
  );
};

export default BoardSidebar;
