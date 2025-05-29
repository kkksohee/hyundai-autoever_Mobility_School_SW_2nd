import styled from "styled-components";

const NewsItemBlock = styled.div`
  display: flex;
  .thumbnail {
    margin-right: 1em;
    img {
      display: block;
      width: 160px;
      height: 100px;
      object-fit: cover;
    }
  }
  .contents {
    h2 {
      margin: 0;
      a {
        color: black;
      }
    }
    p {
      margin: 0;
      line-height: 1.5;
      margin-top: 0.5rem;
      white-space: normal;
    }
  }
  & + & {
    margin-top: 3em;
  }
`;

//구조 분해 할당
//props.article을 미리 분해해서 article만 직접 받는 방식
const NewsItem = ({ article }) => {
  //구조 분해 해여 article.title -> title 로 사용 가능
  const { title, descripstion, url, urlToImage } = article;
  return (
    <NewsItemBlock>
      {urlToImage && (
        <div className="thumbnail">
          <a href={url} target="_balck" rel="nooperner noreferrer">
            <img src={urlToImage} alt="thumbnail" />
          </a>
        </div>
      )}
      <div className="contents">
        <h2>
          <a href={url} target="_black" rel="nooperner noreferrer">
            {title}
          </a>
          <p>{descripstion}</p>
        </h2>
      </div>
    </NewsItemBlock>
  );
};

export default NewsItem;
