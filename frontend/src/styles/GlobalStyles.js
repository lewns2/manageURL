import { createGlobalStyle } from 'styled-components';
import theme from './theme';

const GlobalStyles = createGlobalStyle`

body {
    background-color: ${theme.colors.WHITE};
}

a {
    text-decoration: none;
    color: inherit;
}

ul {
    list-style-type: none;
    padding: 0;
}

button {
  cursor: pointer;
}

`;

export default GlobalStyles;
