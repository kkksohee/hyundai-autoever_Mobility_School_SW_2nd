import { createContext, useState } from "react";
export const UserContext = createContext(null); //사용할 저장소 만듬
// export 는 빼낼때 {}넣어야 함

const UserStore = (props) => {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [userName, setUserName] = useState("");

  // useState하나의 컴포넌트 내에서 사용 가능
  // {props.children} children :컴포넌트 html 등등 모든 요소 다 올 수 있음 라우터조차 감아버림
  // App.js의 모든 요소가 children으로 들어감
  return (
    // 전역상태관리 구간
    <UserContext.Provider
      value={{
        userId,
        setUserId,
        password,
        setPassword,
        userName,
        setUserName,
      }}
    >
      {props.children}
    </UserContext.Provider>
  );
};
export default UserStore;
