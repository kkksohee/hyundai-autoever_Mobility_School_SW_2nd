import { useState } from "react";

const Say = () => {
  // message:값을 읽는 변수
  // setMessage:값을 변경하는 함수(바로읽으면 안바뀌고 랜더링이 일어난 후에 변경됨(랜더링 발생))
  // 주소가 바뀌어야만 랜더링 일어남
  const [message, setMessage] = useState(""); //상태관리
  const onClickEnter = () => setMessage("안녕하세요!!");
  const onclickLeave = () => setMessage("안녕히가세요!!");
  const [color, setColor] = useState("black"); //기본값값
  return (
    <>
      {/* 등록만 함()없음, 이벤트 핸들러가 감지 */}
      <button onClick={onClickEnter}>입장</button>
      <button onClick={onclickLeave}>입장</button>
      {/*리액트와 뷰랑 반대, 뷰: style-> {}한개 
      리액트 style할때 객체가 들어가야함. 객체가 없기 때문에 바로 집어넣기 위해서
      *키와 값이 이름이 같으면 하나만 써도 됨 */}
      <h1 style={{ color }}>{message}</h1>
      <button style={{ color: "red" }} onClick={() => setColor("red")}>
        빨간색
      </button>
      <button style={{ color: "green" }} onClick={() => setColor("green")}>
        초록색
      </button>
      <button style={{ color: "blue" }} onClick={() => setColor("blue")}>
        파란색
      </button>
    </>
  );
};

export default Say;
