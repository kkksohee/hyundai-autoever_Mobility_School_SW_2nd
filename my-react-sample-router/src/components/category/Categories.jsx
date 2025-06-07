import styled, { css } from "styled-components";

const categories = [
  {
    name: "all",
    title: "전체보기",
  },
  {
    name: "business",
    text: "비즈니스",
  },
  {
    name: "entertainment",
    text: "엔터테인먼트",
  },
  {
    name: "health",
    text: "건강",
  },
  {
    name: "sport",
    text: "스포츠",
  },
  {
    name: "technology",
    text: "기술",
  },
];

const CategoriesBlock = styled.div`
  display: flex;
  padding: 1rem;
  width: 768px;
  margin: 0 auto;
  // 화면 너비가 768픽셀 이하 적용
  @media screen and (max-width: 768px) {
    width: 100%;
    overflow-x: auto; //가로축에서 요소의 컨텐츠가 부모 요소의 너비를 초과할 경우 스크롤바 생성
  }
`;

// ${} :styled-components는 내부적으로 JavaScript 템플릿 리터럴을 사용
// 템플릿 리터럴에서 변수를 넣기 위한 문법
// props.active && css ... : props.active가 true일 때만 css를 적용
const Category = styled.div`
  font-size: 1.125rem;
  cursor: pointer;
  white-space: pre; // 공백이나 줄바꿈이 있는 경우 그대로 표시
  text-decoration: none;
  padding-bottom: 0.25rem;

  &:hover {
    color: #495057;
  }
  ${(props) =>
    props.active &&
    css`
      font-weight: 600;
      border-bottom: 2px solid #22bbcf;
      color: #22b8cf;
      &:hover {
        color: #3bc9db;
      }
    `}

  & + & {
    margin-left: 1rem;
  }
`;

//구조분해 할당
// News(부모)에서 onSelect, category 받아옴
const Categories = ({ onSelect, category }) => {
  return (
    //     categories라는 배열을 반복(map)해서,
    // 각 항목마다 Category 컴포넌트를 하나씩 만들어 화면에 보여줌
    <CategoriesBlock>
      {categories.map((c) => (
        // active props로 현재 선택된 카테고리인지 여부를 전달
        // onClick 이벤트가 발생하면 onSelect(c.name)을 호출해서 선택된 카테고리를 알려줌
        <Category
          key={c.name}
          active={category === c.name}
          onClick={() => onSelect(c.name)}
        >
          {c.text}
        </Category>
      ))}
    </CategoriesBlock>
  );
};
export default Categories;
