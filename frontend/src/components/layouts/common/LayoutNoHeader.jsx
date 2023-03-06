import * as S from './LayoutWithHeader.styles.js';

const LayoutWithHeader = ({ children }) => {
  return (
    <>
      <S.Container>{children}</S.Container>
    </>
  );
};

export default LayoutWithHeader;
