import { useState, useEffect } from "react";
import styled from "styled-components";
import NewsItem from "./NewsItem";
import axios from "axios";

const NewsListBlock = styled.div`
  box-sizing: border-box;
  padding-bottom: 3em;
  width: 768px;
  margin: 0 auto;
  margin-top: 2rem;
  @media screen and (max-width: 768px) {
    witdh: 100%;
    padding-left: 1em;
    padding-right: 1em;
  }
`;

const NewsList = (props) => {
  const [articles, setArticles] = useState(null);
  const [loading, setLoading] = useState(false);

  //useEffect에 등록되는 함수에 async를 붙이면 안됨
  // useEffect내부에서 async/await를 사용하는 경우 함수 내부에
  // async 키워드가 붙은 또다른 함수를 만들어서 사용함
  useEffect(() => {
    //처음 랜더링될 때 한번만 실행되도록, 마운트 시 한 번만 실행
    const fetchData = async () => {
      setLoading(true);
      try {
        // 현재 props로 받아온 category에 따라 카테고리를ㄹ 지정하여 API 요청
        // 주소가 변경될 때마다 뉴스를 불러와야함
        const query =
          props.category === "all" ? "all" : `category=${props.category}`;
        const response = await axios.get(
          `https://newsapi.org/v2/top-headlines?country=us&${query}&apiKey=78bb626c65a146b8abc27d6f8c377a2e`
        );
        console.log(response.data.articles);
        //API응답(JSON 객체)에서 필요한 articles 배열 setArticles에 저장
        setArticles(response.data.articles);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };
    //함수 실행, useEffect 안에 async 함수를 직접 쓸 수 없기 때문
    fetchData();
  }, [props.category]);

  //대기 중일 때
  if (loading) {
    return <NewsListBlock>대기중...</NewsListBlock>;
  }
  if (!articles) return null;

  return (
    <NewsListBlock>
      {articles &&
        articles.map((article) => (
          <NewsItem key={article.url} article={article} />
        ))}
    </NewsListBlock>
  );
};

export default NewsList;
