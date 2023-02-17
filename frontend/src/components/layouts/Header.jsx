import { Link } from 'react-router-dom';
import { styleUtils } from '../../styles';

const Header = () => {
  return (
    <header>
      <nav>
        <div className={`${styleUtils.flex} ${styleUtils.gap15}`}>
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
        </div>
      </nav>
    </header>
  );
};

export default Header;
