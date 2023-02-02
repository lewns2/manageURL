import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <header>
      <div>
        <Link to="/">
          <h3>HOME</h3>
        </Link>
      </div>
      <div>
        <Link to="login">
          <h3>LOGIN</h3>
        </Link>
      </div>
    </header>
  );
};

export default Header;
