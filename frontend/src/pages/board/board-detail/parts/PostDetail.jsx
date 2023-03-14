import {
  DetailDescription,
  DetailInfo,
  DetailTitle,
  ItemCategory,
  ItemUrl,
  UrlContainer,
  UrlItemWrapper,
} from '../../../../components/layouts/board';
import { SubTitle, Content } from '../../../../components/parts';

const PostDetail = ({ resource }) => {
  const postInfo = resource.read();

  return (
    <>
      <DetailTitle>
        <SubTitle>{postInfo.title}</SubTitle>
      </DetailTitle>

      <DetailInfo>
        <Content>
          {localStorage.getItem('nickName')} | {toDate(postInfo.createDate)} 생성
        </Content>
      </DetailInfo>

      <DetailDescription>
        <Content>{postInfo.description}</Content>
      </DetailDescription>

      <div>
        <SubTitle>관련 URL</SubTitle>
        <UrlContainer>
          {postInfo.urls.map((value, index) => (
            <UrlItemWrapper key={index}>
              <ItemUrl>{value.address} </ItemUrl>
              <ItemCategory>#{value.category}</ItemCategory>
            </UrlItemWrapper>
          ))}
        </UrlContainer>
      </div>
    </>
  );
};

const toDate = (dateString) => {
  const yyyyMMdd = String(dateString);
  const year = yyyyMMdd.substring(0, 4);
  const month = yyyyMMdd.substring(5, 7);
  const date = yyyyMMdd.substring(8, 10);

  return Number(year) + '년 ' + Number(month) + '월 ' + Number(date) + '일 ';
};

export default PostDetail;
