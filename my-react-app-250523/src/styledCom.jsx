import styled, { css } from "styled-components";

// propscolor로 넘어오면 그 색깔, 없으면 blue
const Box = styled.div`
  background: ${(props) => props.color || "blue"};
  padding: 1rem;
  display: flex;
  width: 1024px;
  margin: 0 auto;
  @media (max-width: 1024px) {
    width: 768px;
  }
  @media (max-width: 768px) {
    width: 90%;
  }
`;
// &:자기 자신
// props.inverted : 반전 값
// css`` 스타일 재정의
// & +button : 자기자신과 다음 요소
const Button = styled.button`
  background: white;
  color: black;
  border-radius: 4px;
  padding: 0.5rem;
  box-sizing: border-box;
  font-size: 1rem;
  font-weight: 600;
  &:hover {
    background: rgba(255, 255, 255, 0.5);
  }
  ${(props) =>
    props.inverted &&
    css`
      background: none;
      border: 2px solid white;
      color: white;
      &:hover {
        background: white;
        color: black;
      }
    `};
  & + button {
    margin-left: 1rem;
  }
`;
const StyledCom = () => {
  return (
    <Box color="orangered">
      <Button inverted>안녕하세요</Button>
      <Button>테두리만</Button>
    </Box>
  );
};

export default StyledCom;
