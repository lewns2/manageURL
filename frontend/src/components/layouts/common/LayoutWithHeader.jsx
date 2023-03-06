import Header from '../header/Header';
import * as S from './LayoutWithHeader.styles.js';

const LayoutWithHeader = ({ children }) => {
  return (
    <>
      <Header />

      <S.Container>{children}</S.Container>
    </>
  );
};

export default LayoutWithHeader;
