import { useState, useEffect } from "react";

const Info = () => {
  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");

  useEffect(() => {
    console.log("랜더링이 완료되었습니다.");
    console.log(name, nickname);
  }, [name]); //아무것도 없는 경우
  // name에 작성할 때만 리랜더링
  // 비워두면 리랜더링 x
  // 들어올 수 있는 값들 :useState로 적은 값들, props값들

  const onChangeName = (e) => {
    setName(e.target.value);
  };
  const onChangeNickname = (e) => {
    setNickname(e.target.value);
  };
  return (
    <>
      <input value={name} onChange={onChangeName} />
      <br />
      <input value={nickname} onChange={onChangeNickname} />
      <p>이름: {name}</p>
      <p>닉네임: {nickname}</p>
    </>
  );
};

export default Info;
