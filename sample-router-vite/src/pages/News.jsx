import { useState, useCallback } from "react";
import NewsList from "../components/news/NewsList";
import Categories from "../components/category/Categories";
import { useParams } from "react-router-dom";

const News = () => {
  const params = useParams();
  //카테고리가 선택 되지 않았으면 기본값 all로 사용용
  const category = params.category || "all";

  //  const [category, setCategory] = useState("all");
  // // 사용자가 카테고리를 클릭했을 때 호출되는 함수.
  // // 클릭한 카테고리 이름을 받아서 category 상태를 변경함.
  // const onSelect = (category) => setCategory(category);

  return (
    <div>
      {/* <Categories category={category} onSelect={onSelect} /> */}
      <Categories />
      <NewsList category={category} />
    </div>
  );
};
export default News;
