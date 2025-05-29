import React, { useState, useContext } from "react";
import { UserContext } from "../store/UserStore";
import { Link, useNavigate } from "react-router-dom";

const SignUp = () => {
  const navigate = useNavigate();
  const [inputId, setInputId] = useState("");
  const [inputPw, setInputPw] = useState("");
  const [inputName, setInputName] = useState("");

  const context = useContext(UserContext);
  const { setUserId, setPassword, setUserName } = context;

  const handleSingUp = () => {
    setUserId(inputId);
    setPassword(inputPw);
    setUserName(inputName);

    localStorage.setItem("inputId", inputId);
    localStorage.setItem("inputPw", inputPw);
    localStorage.setItem("inputName", inputName);

    alert("회원가입 완료");
    navigate("/");
  };
  return (
    <>
      <input
        type="email"
        value={inputId}
        onChange={(e) => setInputId(e.target.value)}
        placeholder="아이디 입력"
      />
      <br />
      <input
        type="password"
        value={inputPw}
        onChange={(e) => setInputPw(e.target.value)}
        placeholder="비밀번호 입력"
      />
      <br />
      <input
        type="text"
        value={inputName}
        onChange={(e) => setInputName(e.target.value)}
        placeholder="이름 입력"
      />
      <br />
      <button onClick={handleSingUp}>가입</button>
    </>
  );
};
export default SignUp;
