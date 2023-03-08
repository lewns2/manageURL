import { CreateUrlStyle, DeleteUrlStyle } from './BoardCreate.styles';

const Create = ({ children, ...rest }) => {
  return <CreateUrlStyle {...rest}>{children}</CreateUrlStyle>;
};

const Delete = ({ children, ...rest }) => {
  return <DeleteUrlStyle {...rest}>{children}</DeleteUrlStyle>;
};

const UrlCreateMenu = {
  Create,
  Delete,
};

export default UrlCreateMenu;
