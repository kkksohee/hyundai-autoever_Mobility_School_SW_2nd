import React, { useState, useContext } from "react";
import { UserContext } from "../store/UserStore";
import { Link, useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const [inputId, setInputId] = useState("");
  const [inputPw, setInputPw] = useState("");
  const { userId, password } = useContext(UserContext);

  const handleLogin = () => {
    const checkIdAPI = userId === inputId;
    const checkPwdAPI = password === inputPw;
    const checkIdlocal = localStorage.getItem("inputId") === inputId;
    const checkPwdlocal = localStorage.getItem("inputPw") === inputPw;

    if (checkIdAPI && checkPwdAPI && checkIdlocal && checkPwdlocal) {
      alert("홈으로 이동합니다.");
      navigate("/home");
    } else {
      console.log(checkIdAPI);
      console.log(checkPwdAPI);
      console.log(checkIdlocal);
      console.log(checkPwdlocal);
      alert("아이디 또는 비밀번호가 틀렸습니다.");
    }
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
      <button onClick={handleLogin}>로그인</button>
      <br />
      <Link to="/signup">회원가입</Link>
    </>
  );
};
export default Login;
