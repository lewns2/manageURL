import { Link } from 'react-router-dom';
import { styleUtils } from '../../../styles';
import * as S from './Header.styles.js';
import { SubTitle } from '../../parts/font';

const Header = () => {
  return (
    <header>
      <S.Nav>
        <div className={`${styleUtils.flexRight}`}>
          <S.MenuWrapper className={`${styleUtils.flexRow} ${styleUtils.gap15}`}>
            <Link to="/">
              <S.Menu>
                <SubTitle>HOME</SubTitle>
              </S.Menu>
            </Link>

            <S.Menu>
              <Link to="/login">
                <SubTitle>LOGIN</SubTitle>
              </Link>
            </S.Menu>

            <S.Menu>
              <Link to="/board">
                <SubTitle>BOARD</SubTitle>
              </Link>
            </S.Menu>
          </S.MenuWrapper>
        </div>
      </S.Nav>
    </header>
  );
};

export default Header;
