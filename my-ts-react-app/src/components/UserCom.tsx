import React from "react";

interface User {
  name: string;
  age: number;
  isAdult: boolean;
}

// user라는 타입이 User라는 객체 타입
interface UserProps{
  user: User;
}

{/* <UserPros>제너릭 문법 */}
const UserComponent: React.Fc<UserProps> = ({usesr})=>{
return (
    <div>
      <h3>인터페이스 예시</h3>
      <p>Name: {user.name}</p>
      <p>Age: {user.age}</p>
      <p>Is Adult: {user.isAdult ? "Yes" : "No"}</p>
    </div>
  );
};

export default UserComponent;