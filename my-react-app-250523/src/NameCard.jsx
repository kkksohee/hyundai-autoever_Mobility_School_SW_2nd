import { useState } from "react";
//이름, 직책, 회사명, 회사주소, 이메일, 전화번호를
// 입력 받아 제출 버튼을 누르면 한번에 출력하기

// 컴포넌트가 두 개인 임

// ({nameCard}): 객체를 받은 것
const NameCardPrn = ({ nameCard }) => {
  return (
    <>
      <h3>명함 정보 출력</h3>
      <p>이름: {nameCard.name}</p>
      <p>직책 : {nameCard.position}</p>
      <p>회사 : {nameCard.company}</p>
      <p>주소 : {nameCard.addr}</p>
      <p>메일 : {nameCard.email}</p>
      <p>전화 : {nameCard.phone}</p>
    </>
  );
};

const NameCard = () => {
  const [nameCard, setNameCard] = useState({
    name: "",
    position: "",
    company: "",
    addr: "",
    email: "",
    phone: "",
  });

  // 계산된 속성명
  // useState를 6개 만들어 버리면 됨. 그걸 근데 객체로 만들어버린거임
  // 공통된 함수를 만들기 위해서
  const [submit, setsubmit] = useState(false);
  const onSubmit = () => {
    setsubmit(true);
  };

  const onChange = (key, value) => {
    // 불변성의 원칙을 지키기 위해
    // 기존에 알고 있는 값을 풀어서 넣음
    // nameCard[key]= value;
    // setNameCard(nameCard); <- 이렇게 쓰면 안됨
    setNameCard({ ...nameCard, [key]: value });
  };

  return (
    <>
      <h3>입력하세요~</h3>

      {/* 변경값을 감지하는 onChange 그다음 onChange는 내가 만든 */}
      <input
        placeholder="이름"
        value={nameCard.name}
        onChange={(e) => onChange("name", e.target.value)}
      />
      <input
        placeholder="직책"
        value={nameCard.position}
        onChange={(e) => onChange("position", e.target.value)}
      />
      <input
        placeholder="회사명"
        value={nameCard.company}
        onChange={(e) => onChange("company", e.target.value)}
      />
      <input
        placeholder="회사주소"
        value={nameCard.addr}
        onChange={(e) => onChange("addr", e.target.value)}
      />
      <input
        placeholder="이메일"
        value={nameCard.email}
        onChange={(e) => onChange("email", e.target.value)}
      />
      <input
        placeholder="전화번호"
        value={nameCard.phone}
        onChange={(e) => onChange("phone", e.target.value)}
      />

      <br />
      <button onClick={onSubmit}>제출</button>
      {/* submit값이 있으면 && 출력함  props사용*/}
      {submit && <NameCardPrn nameCard={nameCard} />}
    </>
  );
};

export default NameCard;
