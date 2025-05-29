import { useState } from "react";

const EventInput = () => {
  const [message, setMessage] = useState("안녕하세요");

  // 뷰에서는 v-model에서 자동으로 해줌
  // setMessage가 불릴때마다 리랜더링(화면다시그려줌)
  const changeMsg = (event) => {
    setMessage(event.target.value);
  };
  return (
    <>
      {/* onChange: 값이 변경했을 때 onChange이벤트 일어남(입력했을 때)
    함수 부르기(changeMsg)
    (e)=>changeMsg(e) 이벤트에 한에서 생략 가능  */}
      <input placeholder="인사말 입력" value={message} onChange={changeMsg} />
      <h2>입력받은 메세지:{message}</h2>
      {/* input 요소는 useState로 관리하지 않아도 랜더링 됨
      html from으로 자체 랜더링 */}
    </>
  );
};

export default EventInput;
