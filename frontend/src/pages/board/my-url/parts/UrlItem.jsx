import { ItemCategory, ItemUrl, ItemPost } from '../../../../components/layouts/board';

const UrlItem = ({ url }) => {
  return (
    <>
      <ItemUrl onClick={() => window.open(url.address)}>{url.address}</ItemUrl>
      <ItemPost>연관 게시글 - 글 제목</ItemPost>
      <ItemCategory># {url.category}</ItemCategory>
    </>
  );
};

export default UrlItem;
