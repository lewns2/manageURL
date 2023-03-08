import { UrlContainer, UrlItemWrapper } from '../../../../components/layouts/board/my-url';
import UrlItem from './UrlItem';

const UrlList = ({ resource }) => {
  const urlList = resource.read();

  return (
    <UrlContainer>
      {urlList &&
        urlList.map((url, index) => (
          <UrlItemWrapper key={index}>
            <UrlItem url={url}></UrlItem>
          </UrlItemWrapper>
        ))}
    </UrlContainer>
  );
};

export default UrlList;
