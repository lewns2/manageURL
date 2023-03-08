import { ItemUrlStyle } from './MyUrl.styles';

const ItemUrl = ({ children, ...rest }) => {
  return <ItemUrlStyle {...rest}>{children}</ItemUrlStyle>;
};

export default ItemUrl;
